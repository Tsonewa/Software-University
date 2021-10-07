package com.example.football.service;

import com.example.football.domain.entities.Team;
import com.example.football.domain.entities.dtos.TeamSeedRootDto;
import com.example.football.repository.PictureRepository;
import com.example.football.repository.TeamRepository;
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
public class TeamServiceImpl implements TeamService {

    public static final String TEAM_FILE_PATH = "src/main/resources/files/xml/teams.xml";

    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final XMLParser xmlParser;
    private final ValidatorUtil validatorUtil;
    private final TeamRepository teamRepository;
    private final PictureRepository pictureRepository;

    public TeamServiceImpl(FileUtil fileUtil, ModelMapper modelMapper, XMLParser xmlParser, ValidatorUtil validatorUtil, TeamRepository teamRepository, PictureRepository pictureRepository) {
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validatorUtil = validatorUtil;
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public String importTeams() throws IOException {

        return fileUtil.readFile(TEAM_FILE_PATH);
    }

    @Override
    public boolean areImported() {

        return this.teamRepository.count() > 0;
    }

    @Override
    public String readTeamsXmlFile() throws JAXBException, FileNotFoundException {

        StringBuilder sb = new StringBuilder();

        TeamSeedRootDto teamSeedRootDto = xmlParser.fromFIle
                (TEAM_FILE_PATH, TeamSeedRootDto.class);

       teamSeedRootDto
                .getTeams()
                .stream()
                .filter(teamsSeedDto -> {
                    boolean isValid = validatorUtil.isValid(teamsSeedDto)
                             && isPictureExist(teamsSeedDto.getPicture().getUrl());

                    sb.append(isValid ? String.format("Successfully imported - %s",
                            teamsSeedDto.getName())
                            : "Invalid Team")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(o -> {

                    Team team = modelMapper.map(o, Team.class);

                    team.setPicture(pictureRepository.getPictureByUrl(o.getPicture().getUrl()));

                    return team;

                }).forEach(teamRepository::save);

        return sb.toString();
    }

    private boolean isPictureExist(String url) {

    return pictureRepository.existsByUrl(url);
    }
}
