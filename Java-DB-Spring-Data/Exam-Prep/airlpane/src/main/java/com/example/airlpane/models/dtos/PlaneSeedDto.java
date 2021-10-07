package com.example.airlpane.models.dtos;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlaneSeedDto {

    @XmlElement(name = "register-number")
    private String registerNumber; // minimum length 5  - is unique.
    @XmlElement
    private Integer capacity; // must be positive).
    @XmlElement
    private String airline; // min length of 2.

    public PlaneSeedDto() {
    }

    public PlaneSeedDto(String registerNumber, Integer capacity, String airline) {
        this.registerNumber = registerNumber;
        this.capacity = capacity;
        this.airline = airline;
    }
    @Size(min = 5)
    public String getRegisterNumber() {
        return registerNumber;
    }


    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }
    @Positive
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Size(min = 2)
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }
}
