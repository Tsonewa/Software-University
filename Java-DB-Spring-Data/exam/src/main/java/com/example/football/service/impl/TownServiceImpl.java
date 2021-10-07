package com.example.football.service.impl;

import com.example.football.models.dto.TownSeedDto;
import com.example.football.models.entity.Town;
import com.example.football.repository.TeamRepository;
import com.example.football.repository.TownRepository;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TownServiceImpl implements TownService {

    public static final String TOWN_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final TeamRepository teamRepository;
    private final TownRepository townRepository;

    public TownServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, TeamRepository teamRepository, TownRepository townRepository) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.teamRepository = teamRepository;
        this.townRepository = townRepository;
    }


    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent(), TownSeedDto[].class))
                .filter(townSeedDto -> {
                    boolean isValid = validationUtil.isValid(townSeedDto)
                            && !isTownExist(townSeedDto.getName());

                    sb.append(isValid ? String.format("Successfully imported Town %s - %d",
                            townSeedDto.getName(),
                            townSeedDto.getPopulation()) :
                            "Invalid Town")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(townSeedDto -> modelMapper.map(townSeedDto, Town.class))
        .forEach(townRepository::save);

        return sb.toString();
    }

    @Override
    public boolean isTownExist(String name) {
        
        return townRepository.existsByName(name);
    }

    @Override
    public Town getTownByName(String townName) {
        
        return townRepository.findByName(townName);
    }
}
