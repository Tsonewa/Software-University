package com.example.airlpane.models.dtos;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneRegisterNumberDto {

    @XmlElement(name = "register-number")
    private String registerNumber;

    public PlaneRegisterNumberDto(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public PlaneRegisterNumberDto() {
    }

    @Size(min = 5)
    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }
}
