package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture;
import softuni.exam.instagraphlite.models.dtos.PictureSeedDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    public static final String PICTURES_FILE_PATH = "src/main/resources/files/pictures.json";

    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final PictureRepository pictureRepository;

    public PictureServiceImpl(ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper, PictureRepository pictureRepository) {
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public boolean areImported() {

        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {


        return Files.readString(Path.of(PICTURES_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readFromFileContent(), PictureSeedDto[].class))
                .filter(picturesSeedDto -> {
                    boolean isValid = validationUtil.isValid(picturesSeedDto)
                            && !isEntityExist(picturesSeedDto.getPath());

                    sb.append(isValid
                            ? String.format
                            ("Successfully imported Picture, with size - %.2f",
                                    picturesSeedDto.getSize()) :
                            "Invalid picture")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(pic -> modelMapper.map(pic, Picture.class))
                .forEach(pictureRepository::save);

        return sb.toString();
    }

    private boolean isEntityExist(String path) {

        return pictureRepository.existsByPath(path);
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();

        pictureRepository.findAllBySizeGreaterThanOrderBySize(30000.00)
                .forEach(p -> {
                    sb.append(String.format("%.2f - %s",
                            p.getSize(), p.getPath()))
                            .append(System.lineSeparator());
                });
        return sb.toString();
    }
}
