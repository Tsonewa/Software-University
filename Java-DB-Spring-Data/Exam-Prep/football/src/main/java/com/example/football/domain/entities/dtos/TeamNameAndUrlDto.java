package com.example.football.domain.entities.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeamNameAndUrlDto {
@Expose
private String name;
@Expose
private PictureUrlDto picture;

    public TeamNameAndUrlDto() {
    }

    public TeamNameAndUrlDto(String name, PictureUrlDto picture) {
        this.name = name;
        this.picture = picture;
    }
@NotNull
@Size(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public PictureUrlDto getPicture() {
        return picture;
    }

    public void setPicture(PictureUrlDto picture) {
        this.picture = picture;
    }
}
