package com.example.football.service;

import com.example.football.domain.entities.Picture;
import com.example.football.domain.entities.dtos.PicturesSeedRootDto;
import com.example.football.repository.PictureRepository;
import com.example.football.util.FileUtil;
import com.example.football.util.ValidatorUtil;
import com.example.football.util.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PictureServiceImpl implements PictureService {

    public static final String PICTURE_FILE_PATH = "src/main/resources/files/xml/pictures.xml";

    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final PictureRepository pictureRepository;

    public PictureServiceImpl(FileUtil fileUtil, ModelMapper modelMapper, XMLParser xmlParser, ValidatorUtil validatorUtil, PictureRepository pictureRepository) {
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String importPictures() throws IOException {

        return fileUtil.readFile(PICTURE_FILE_PATH);
    }

    @Override
    public boolean areImported() {

        return this.pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesXmlFile() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        PicturesSeedRootDto picturesSeedRootDto = xmlParser.fromFIle
                (PICTURE_FILE_PATH, PicturesSeedRootDto.class);
        picturesSeedRootDto
                .getPictures()
                .stream()
                .filter(pictureUrlDto -> {
                    boolean isValid = validatorUtil.isValid(picturesSeedRootDto)
                            && pictureUrlDto.getUrl() != null;

                    sb.append(isValid ? String.format("Successfully import Picture - %s",
                            pictureUrlDto.getUrl())
                            : "Invalid Picture")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(o -> modelMapper.map(o, Picture.class))
              .forEach(pictureRepository::save);

        return sb.toString();

    }

}
