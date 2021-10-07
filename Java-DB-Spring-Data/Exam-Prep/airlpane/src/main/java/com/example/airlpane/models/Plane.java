package com.example.airlpane.models;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "planes")
public class Plane extends BaseEntity{

   private String registerNumber; // minimum length 5  - is unique.
   private Integer capacity; // must be positive).
    private String airline; // min length of 2.
    private List<Ticket> tickets;

    public Plane() {
    }

    public Plane(String registerNumber, Integer capacity, String airline, List<Ticket> tickets) {
        this.registerNumber = registerNumber;
        this.capacity = capacity;
        this.airline = airline;
        this.tickets = tickets;
    }

    @Column(name = "register_number", unique = true)
    @Size(min = 5)
    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Column
    @Positive
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Column
    @Size(min = 2)
    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @OneToMany(mappedBy = "plane", cascade = CascadeType.ALL)
    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}

