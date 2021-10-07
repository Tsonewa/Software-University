package com.example.hiberspring.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;

public class TownNameAndPopulationDto {
    @Expose
    private String name;
    @Expose
    private Integer population;

    public TownNameAndPopulationDto() {
    }

    public TownNameAndPopulationDto(String name, Integer population) {
        this.name = name;
        this.population = population;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
}
