package com.example.airlpane.models;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger extends BaseEntity {


  private String firstName; // char sequence with minimum length 2.

    private String lastName; // minimum length 2.

    private Integer age;  // (must be positive).

    private String phoneNumber; // a char sequence – phone number.

    private String email; // (must contains ‘@’ and ‘.’ – dot). The email of a person is unique
    private Town town;
    private List<Ticket> tickets;

  public Passenger() {
  }

  public Passenger(String firstName, String lastName, Integer age, String phoneNumber, String email, Town town) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.town = town;
  }

  @Column(name = "first_name")
  @Size(min = 2)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Column(name = "last_name")
  @Size(min = 2)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Column
  @Positive
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  @Column(name = "phone_number")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

@Email
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @ManyToOne
  public Town getTown() {
    return town;
  }

  public void setTown(Town town) {
    this.town = town;
  }

  @OneToMany(mappedBy = "passenger", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  public List<Ticket> getTickets() {
    return tickets;
  }

  public void setTickets(List<Ticket> tickets) {
    this.tickets = tickets;
  }
}

