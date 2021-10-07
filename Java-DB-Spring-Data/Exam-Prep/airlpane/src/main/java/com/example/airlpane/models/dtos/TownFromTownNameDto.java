package com.example.airlpane.models.dtos;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TownFromTownNameDto {

    @XmlElement
    private String name;

    public TownFromTownNameDto() {
    }

    public TownFromTownNameDto(String name) {
        this.name = name;
    }

    @Size(min = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
