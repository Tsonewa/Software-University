package com.example.airlpane.models;


import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{

   private String name; // minimum length 2. The name is unique.
     private Integer population; // number (must be positive).
    private String guide; // Text
    private List<Passenger> passengers;

    public Town() {
    }

    @Column
    @Size(min = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    @Positive
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    @Column(columnDefinition = "TEXT")
    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    @OneToMany(mappedBy = "town", cascade = CascadeType.ALL)
    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }
}
