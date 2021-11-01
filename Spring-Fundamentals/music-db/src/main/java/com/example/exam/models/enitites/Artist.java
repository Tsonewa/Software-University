package com.example.exam.models.enitites;

import com.example.exam.models.enitites.enums.ArtistNameEnum;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class Artist extends BaseEntity{

    @Enumerated
            (value = EnumType.STRING)
    private ArtistNameEnum name;
    @Column(name = "career_information", columnDefinition = "TEXT")
    private String careerInformation;

    public Artist() {
    }

    public ArtistNameEnum getName() {
        return name;
    }

    public void setName(ArtistNameEnum name) {
        this.name = name;
    }

    public String getCareerInfo() {
        return careerInformation;
    }

    public void setCareerInfo(String careerInfo) {
        this.careerInformation = careerInfo;
    }
}
