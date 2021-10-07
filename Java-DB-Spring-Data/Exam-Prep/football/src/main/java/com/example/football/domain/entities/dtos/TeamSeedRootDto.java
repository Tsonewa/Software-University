package com.example.football.domain.entities.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "teams")
@XmlAccessorType(XmlAccessType.FIELD)
public class TeamSeedRootDto {

    @XmlElement(name = "team")
private List<TeamsSeedDto> teams;

    public TeamSeedRootDto() {
    }

    public TeamSeedRootDto(List<TeamsSeedDto> teams) {
        this.teams = teams;
    }

    public List<TeamsSeedDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamsSeedDto> teams) {
        this.teams = teams;
    }
}
