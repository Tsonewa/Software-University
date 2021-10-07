package com.example.football.domain.entities.dtos;

import com.example.football.domain.entities.Position;
import com.google.gson.annotations.Expose;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;

public class PlayersSeedDto {
    @Expose
    private String firstName;
    @Expose
private String lastName;
    @Expose
private Integer number;
    @Expose
private BigDecimal salary;
    @Expose
private Position position;
    @Expose
private PictureUrlDto picture;
    @Expose
private TeamNameAndUrlDto team;

    public PlayersSeedDto() {
    }

    public PlayersSeedDto(String firstName, String lastName, Integer number, BigDecimal salary, Position position, PictureUrlDto picture, TeamNameAndUrlDto team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.salary = salary;
        this.position = position;
        this.picture = picture;
        this.team = team;
    }

    @NotNull
    @NotBlank
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @NotNull
    @Size(min = 3, max = 15)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Min(value = 1)
    @Max(value = 99)
    @NotNull
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @NotNull
    @DecimalMin(value = "0")
    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Enumerated(EnumType.ORDINAL)
    @NotNull
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @NotNull
    public PictureUrlDto getPicture() {
        return picture;
    }

    public void setPicture(PictureUrlDto picture) {
        this.picture = picture;
    }

    @NotNull
    public TeamNameAndUrlDto getTeam() {
        return team;
    }

    public void setTeam(TeamNameAndUrlDto team) {
        this.team = team;
    }
}
