package com.example.football.domain.entities.dtos;


import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PictureUrlDto {

    @XmlElement
    @Expose
    private String url;

    public PictureUrlDto() {
    }

    public PictureUrlDto(String url) {
        this.url = url;
    }

    @NotBlank
    @NotNull
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
