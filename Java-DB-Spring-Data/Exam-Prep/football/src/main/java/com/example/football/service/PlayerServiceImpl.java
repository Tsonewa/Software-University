package com.example.football.service;

import com.example.football.domain.entities.Player;
import com.example.football.domain.entities.Position;
import com.example.football.domain.entities.dtos.PlayersSeedDto;
import com.example.football.repository.PictureRepository;
import com.example.football.repository.PlayerRepository;
import com.example.football.repository.TeamRepository;
import com.example.football.util.FileUtil;
import com.example.football.util.ValidatorUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    public static final String PLAYER_FILE_PATH = "src/main/resources/files/json/players.json";

    private final FileUtil fileUtil;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final TeamRepository teamRepository;
    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final PlayerRepository playerRepository;

    public PlayerServiceImpl(FileUtil fileUtil, ModelMapper modelMapper, ValidatorUtil validatorUtil, TeamRepository teamRepository, PictureRepository pictureRepository, Gson gson, PlayerRepository playerRepository) {
        this.fileUtil = fileUtil;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.teamRepository = teamRepository;
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.playerRepository = playerRepository;
    }

    @Override
    public String importPlayers() throws IOException {

        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readPlayersJsonFile(), PlayersSeedDto[].class))
                .filter(playerSeedDto -> {
                    boolean isValid = validatorUtil.isValid(playerSeedDto);

                    sb.append(isValid ? String.format("Successfully imported player: %s %s",
                            playerSeedDto.getFirstName(),
                            playerSeedDto.getLastName())
                            :
                            "Invalid player")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(playersSeedDto -> {
                    Player player = modelMapper.map(playersSeedDto, Player.class);


            Position position = Position.valueOf(playersSeedDto.getPosition().name());
            player.setPosition(position);

            player.setPicture(pictureRepository.getPictureByUrl(playersSeedDto.getPicture().getUrl()));
            player.setTeam(teamRepository.getTeamByName(playersSeedDto.getTeam().getName()));
            player.getTeam().setPicture(pictureRepository.getPictureByUrl(playersSeedDto.getTeam().getPicture().getUrl()));

                    return player;
                })
           .forEach(playerRepository::save);

        return sb.toString();
    }

    @Override
    public boolean areImported() {

        return pictureRepository.count() > 0;
    }

    @Override
    public String readPlayersJsonFile() throws IOException {

        return fileUtil.readFile(PLAYER_FILE_PATH);
    }

    @Override
    public String exportPlayersWhereSalaryBiggerThan() {
       StringBuilder sb = new StringBuilder();

       playerRepository.getAllBySalaryIsGreaterThanOrderBySalaryDesc(BigDecimal.valueOf(100000L))
               .forEach(p -> {

                   sb.append(String.format("Player name: %s %s",
                           p.getFirstName(), p.getLastName()))
                           .append(System.lineSeparator())
                           .append(String.format("\tNumber: %d",
                                   p.getNumber()))
                           .append(System.lineSeparator())
                           .append(String.format("\tSalary: %.2f",
                                   p.getSalary()))
                           .append(System.lineSeparator())
                           .append(String.format("Team: %s",
                                   p.getTeam().getName()))
                           .append(System.lineSeparator());

               });

       return sb.toString();
    }

    @Override
    public String exportPlayersInATeam() {

        StringBuilder sb = new StringBuilder();

        playerRepository.getAllByTeamName()
                .forEach(t -> {

                    sb.append(
                            String.format("Team: %s", t.getTeam().getName())
                    ).append(System.lineSeparator());

                   t.getTeam().getPlayers()
                           .forEach(p -> {

                               sb.append(String.format("\tPlayer name: %s %s - %s\n" +
                                       "Number: %d ",
                                       p.getFirstName(),
                                       p.getFirstName(),
                                       p.getPosition().name(),
                                       p.getNumber()))
                                       .append(System.lineSeparator());
                           });

                });

        return sb.toString();
    }
}
