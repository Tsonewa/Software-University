package com.example.football.service;

import com.example.football.models.entity.Team;

import java.io.IOException;

public interface TeamService {
    boolean areImported();

    String readTeamsFileContent() throws IOException;

    String importTeams() throws IOException;

    boolean isTeamExist(String name);

    Team getTeamByName(String name);
}
