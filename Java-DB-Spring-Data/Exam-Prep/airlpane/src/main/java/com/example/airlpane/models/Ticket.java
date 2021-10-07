package com.example.airlpane.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity{

   private String serialNumber; // @Pattern(regex = "[a-zA-Z0-9]{2, }") unique
   private BigDecimal price; // positive.
   private LocalDateTime takeoff;  // а date and time of plane taking off.

    private Town fromTown;
    private Town toTown;

    private Passenger passenger;

    private Plane plane;

    public Ticket() {
    }

    public Ticket(String serialNumber, BigDecimal price, LocalDateTime takeoff, Town fromTown, Town toTown, Passenger passenger, Plane plane) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.takeoff = takeoff;
        this.fromTown = fromTown;
        this.toTown = toTown;
        this.passenger = passenger;
        this.plane = plane;
    }

    @Column(name = "serial_number", unique = true)
    @Size(min = 2)
    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Column
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "take_off")
    public LocalDateTime getTakeoff() {
        return takeoff;
    }

    public void setTakeoff(LocalDateTime takeoff) {
        this.takeoff = takeoff;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Town getFromTown() {
        return fromTown;
    }

    public void setFromTown(Town fromTown) {
        this.fromTown = fromTown;
    }

    @OneToOne(cascade = CascadeType.ALL)
    public Town getToTown() {
        return toTown;
    }

    public void setToTown(Town toTown) {
        this.toTown = toTown;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
