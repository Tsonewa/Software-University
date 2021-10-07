package com.example.football.domain.entities.dtos;


import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TeamsSeedDto {
@XmlElement
private String name;
@XmlElement
private PictureUrlDto picture;

    public TeamsSeedDto() {
    }

    public TeamsSeedDto(String name, PictureUrlDto picture) {
        this.name = name;
        this.picture = picture;
    }

    @Size(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PictureUrlDto getPicture() {
        return picture;
    }

    public void setPicture(PictureUrlDto picture) {
        this.picture = picture;
    }
}
