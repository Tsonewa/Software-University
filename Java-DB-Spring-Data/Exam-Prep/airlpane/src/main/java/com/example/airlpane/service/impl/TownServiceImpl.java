package com.example.airlpane.service.impl;

import com.example.airlpane.models.Town;
import com.example.airlpane.models.dtos.TownsSeedDto;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.airlpane.repository.TownRepository;
import com.example.airlpane.service.TownService;
import com.example.airlpane.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TownServiceImpl implements TownService {

    public static final String TOWNS_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final TownRepository townRepository;

    public TownServiceImpl(ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper, TownRepository townRepository) {
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.townRepository = townRepository;
    }

    @Override
    public boolean areImported() {

        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {


        return Files.readString(Path.of(TOWNS_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {

        StringBuilder sb = new StringBuilder();

       Arrays.stream(gson.fromJson(readTownsFileContent(), TownsSeedDto[].class))
                .filter(townsSeedDto -> {
                    boolean isValid = validationUtil.isValid(townsSeedDto)
                            && !isTownExist(townsSeedDto.getName());

                    sb.append(isValid ? String.format("Successfully imported Town %s - %d",
                            townsSeedDto.getName(),
                            townsSeedDto.getPopulation()) :
                            "Invalid Town")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(townsSeedDto -> modelMapper.map(townsSeedDto, Town.class))
                .forEach(townRepository::save);

        return sb.toString();
    }

    @Override
    public Town getTownByName(String town) {
        
        return townRepository.findByName(town);
    }

    private boolean isTownExist(String name) {

        return townRepository.existsByName(name);
    }
}
