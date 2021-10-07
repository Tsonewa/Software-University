package com.example.football.domain.entities.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "pictures")
@XmlAccessorType(XmlAccessType.FIELD)
public class PicturesSeedRootDto {

    @XmlElement(name = "picture")
  private List<PictureUrlDto> pictures;

    public PicturesSeedRootDto() {
    }

    public PicturesSeedRootDto(List<PictureUrlDto> pictures) {
        this.pictures = pictures;
    }

    @NotNull
    public List<PictureUrlDto> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureUrlDto> pictures) {
        this.pictures = pictures;
    }
}
