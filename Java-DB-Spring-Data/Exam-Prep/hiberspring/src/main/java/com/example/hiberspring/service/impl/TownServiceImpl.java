package com.example.hiberspring.service.impl;

import com.example.hiberspring.domain.dtos.TownNameAndPopulationDto;
import com.example.hiberspring.domain.entities.Town;
import com.example.hiberspring.repository.TownRepository;
import com.example.hiberspring.service.TownService;
import com.example.hiberspring.util.FileUtil;
import com.example.hiberspring.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.hiberspring.common.Constants.INCORRECT_DATA_MESSAGE;
import static com.example.hiberspring.common.Constants.PATH_TO_FILES;

@Service
public class TownServiceImpl implements TownService {

    private final Gson gson;
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;

    public TownServiceImpl(Gson gson, TownRepository townRepository, ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil) {
        this.gson = gson;
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
    }

    @Override
    public Boolean townsAreImported() {

        return townRepository.count() > 0;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return fileUtil.readFile("src/main/resources/files/towns.json");
    }

    @Override
    public String importTowns(String townsFileContent) throws IOException {

        StringBuilder sb = new StringBuilder();

       Arrays.stream(gson.fromJson(readTownsJsonFile(), TownNameAndPopulationDto[].class))
                .filter(townNameAndPopulationDto -> {
                    boolean isValid = validationUtil.isValid(townNameAndPopulationDto);

                    sb.append(isValid ? String.format("Successfully imported Town - %s",
                            townNameAndPopulationDto.getName())
                            : INCORRECT_DATA_MESSAGE)
                            .append(System.lineSeparator());

                    return isValid;
                }).map(townNameAndPopulationDto -> modelMapper.map(townNameAndPopulationDto, Town.class))
         .forEach(townRepository::save);

        return sb.toString();
    }
}
