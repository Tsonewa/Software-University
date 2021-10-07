package com.example.airlpane.models.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class TownsSeedDto {

    @Expose
 private String name;
    @Expose
 private Integer population;
    @Expose
 private String guide;

    public TownsSeedDto() {
    }

    public TownsSeedDto(String name, Integer population, String guide) {
        this.name = name;
        this.population = population;
        this.guide = guide;
    }

    @Size(min = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Positive
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }
}
