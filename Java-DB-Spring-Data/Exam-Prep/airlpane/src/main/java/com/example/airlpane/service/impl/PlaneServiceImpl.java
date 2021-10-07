package com.example.airlpane.service.impl;

import com.example.airlpane.models.Plane;
import com.example.airlpane.models.dtos.PlaneSeedRootDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.airlpane.repository.PlaneRepository;
import com.example.airlpane.service.PlaneService;
import com.example.airlpane.util.ValidationUtil;
import com.example.airlpane.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaneServiceImpl implements PlaneService {

    public static final String PLANES_FILE_PATH = "src/main/resources/files/xml/planes.xml";
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;

    public PlaneServiceImpl(ValidationUtil validationUtil, ModelMapper modelMapper, PlaneRepository planeRepository, XmlParser xmlParser) {
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {

        return planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {


        return Files.readString(Path.of(PLANES_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        PlaneSeedRootDto planeSeedRootDto = xmlParser.fromFIle
                (PLANES_FILE_PATH, PlaneSeedRootDto.class);

        planeSeedRootDto
                .getPlanes()
                .stream()
                .filter(planeSeedDto -> {
                    boolean isValid = validationUtil.isValid(planeSeedDto);

                    sb.append(isValid ? String.format("Successfully imported Plane %s",
                            planeSeedDto.getRegisterNumber())
                            : "Invalid Plane")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(p -> modelMapper.map(p, Plane.class))
                .forEach(planeRepository::save);

        return sb.toString();
    }
}
