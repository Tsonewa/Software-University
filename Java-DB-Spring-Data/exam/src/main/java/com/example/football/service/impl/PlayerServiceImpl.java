package com.example.football.service.impl;

import com.example.football.models.dto.PlayersSeedRootDto;
import com.example.football.models.entity.Player;
import com.example.football.models.entity.Position;
import com.example.football.repository.PlayerRepository;
import com.example.football.service.PlayerService;
import com.example.football.service.StatService;
import com.example.football.service.TeamService;
import com.example.football.service.TownService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    public static final String PLAYER_FILE_PATH = "src/main/resources/files/xml/players.xml";

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XMLParser xmlParser;
    private final PlayerRepository playerRepository;
    private final TownService townService;
    private final TeamService teamService;
    private final StatService statService;

    public PlayerServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, XMLParser xmlParser, PlayerRepository playerRepository, TownService townService, TeamService teamService, StatService statService) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.playerRepository = playerRepository;
        this.townService = townService;
        this.teamService = teamService;
        this.statService = statService;
    }


    @Override
    public boolean areImported() {
        return playerRepository.count() > 0;
    }

    @Override
    public String readPlayersFileContent() throws IOException {

        return Files.readString(Path.of(PLAYER_FILE_PATH));
    }

    @Override
    public String importPlayers() throws JAXBException, FileNotFoundException {


        StringBuilder sb = new StringBuilder();

        PlayersSeedRootDto rootDto = xmlParser.fromFIle
                (PLAYER_FILE_PATH, PlayersSeedRootDto.class);

        rootDto
                .getPlayers()
                .stream()
                .filter(playerSeedDto -> {
                    boolean isValid = validationUtil.isValid(playerSeedDto)
                            && !isEmailExist(playerSeedDto.getEmail());

                    sb.append(isValid ? String.format("Successfully import Player %s - %s",
                            playerSeedDto.getFirstName(),
                            playerSeedDto.getPosition())
                            : "Invalid Player")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(playerSeedDto -> {
                    Player player = modelMapper.map(playerSeedDto, Player.class);

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    player.setBirthDate(LocalDate.parse(playerSeedDto.getBirthDate(), formatter));

                    return player;
                }).map(player -> {

                    Player p = modelMapper.map(player, Player.class);

                    p.setTown(townService.getTownByName(player.getTown().getName()));
                    p.setTeam(teamService.getTeamByName(player.getTeam().getName()));

                    p.setStat(statService.getStatById(player.getStat().getId()));
                    return p;
                })
                .forEach(playerRepository::save);

        return sb.toString();
    }

    @Override
    public boolean isEmailExist(String email) {

        return playerRepository.existsByEmail(email);
    }

    @Override
    public String exportBestPlayers() {

        StringBuilder sb = new StringBuilder();

        playerRepository.findAllByBirthDateBetween(LocalDate.parse("01-01-1993", DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                LocalDate.parse("01-01-2003", DateTimeFormatter.ofPattern("dd-MM-yyyy") ))
                .stream()
                .sorted((a,b) -> b.getStat().getShooting().compareTo(a.getStat().getShooting()))
                .sorted((a,b) -> b.getStat().getPassing().compareTo(a.getStat().getPassing()))
                .sorted((a,b) -> b.getStat().getEndurance().compareTo(a.getStat().getEndurance()))
                .forEach(p -> {

                    sb.append(String.format("Player - %s %s", p.getFirstName(), p.getLastName()))
                            .append(System.lineSeparator())
                            .append(String.format("\tPosition - %s",
                                    p.getPosition()))
                            .append(System.lineSeparator())
                            .append(String.format("\tTeam - %s",
                                    p.getTeam().getName()))
                            .append(System.lineSeparator())
                            .append(String.format("\tStadium - %s",
                                    p.getTeam().getStadiumName()))
                            .append(System.lineSeparator());
                });

        return sb.toString();
    }
}
