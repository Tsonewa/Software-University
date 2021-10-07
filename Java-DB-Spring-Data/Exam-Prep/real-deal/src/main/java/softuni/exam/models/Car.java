package softuni.exam.models;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "cars",
        uniqueConstraints = {@UniqueConstraint(columnNames =
                {"make", "model", "kilometers"})})
public class Car extends BaseEntity{

    private String make; // a char sequence (between 2 to 20 exclusive).
    private String model; // a char sequence (between 2 to 20 exclusive).
    private Integer kilometers; // a number (must be positive).
    private LocalDate registeredOn;
    private Set<Picture> pictures;
    private Set<Offer> offers;


    public Car() {
    }

    public Car(String make, String model, Integer kilometers, LocalDate registeredOn) {
        this.make = make;
        this.model = model;
        this.kilometers = kilometers;
        this.registeredOn = registeredOn;
    }

    @Size(min = 2, max = 20)
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }
    @Size(min = 2, max = 20)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Positive
    public Integer getKilometers() {
        return kilometers;
    }

    public void setKilometers(Integer kilometers) {
        this.kilometers = kilometers;
    }

    @Column(name = "registrated_on")
    public LocalDate getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(LocalDate registratedOn) {
        this.registeredOn = registratedOn;
    }

    @OneToMany(mappedBy = "car", targetEntity = Picture.class, fetch = FetchType.EAGER)
    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @OneToMany(mappedBy = "car", targetEntity = Offer.class, cascade = CascadeType.MERGE)
    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
