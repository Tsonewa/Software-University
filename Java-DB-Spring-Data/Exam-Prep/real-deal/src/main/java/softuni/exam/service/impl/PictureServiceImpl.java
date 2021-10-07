package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Picture;
import softuni.exam.models.dtos.PicturesSeedDto;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    public static final String PICTURES_INPUT_FILE_PATH = "src/main/resources/files/json/pictures.json";

    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final PictureRepository pictureRepository;
    private final CarService carService;

    public PictureServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, Gson gson, PictureRepository pictureRepository, CarService carService) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.pictureRepository = pictureRepository;
        this.carService = carService;
    }

    @Override
    public boolean areImported() {

        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString
                (Path.of(PICTURES_INPUT_FILE_PATH)).trim();
    }

    @Override
    public String importPictures() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readPicturesFromFile(), PicturesSeedDto[].class))
                .filter(picturesSeedDto -> {
                    boolean isValid = validationUtil.isValid(picturesSeedDto);

                    sb.append(isValid ? String.format("Successfully imported picture - %s",
                            picturesSeedDto.getName()) :
                            "Invalid picture").append(System.lineSeparator());

                    return isValid;
                }).map(picturesSeedDto -> {
                    Picture picture = modelMapper.map(picturesSeedDto, Picture.class);

                    picture.setCar(carService.getCarById(picturesSeedDto.getCar()));

                    return picture;
                })
                .forEach(pictureRepository::save);

        return sb.toString();

    }

    @Override
    public Set<Picture> getPicturesById(Long id) {

        return pictureRepository.findAllById(id);

    }
}
