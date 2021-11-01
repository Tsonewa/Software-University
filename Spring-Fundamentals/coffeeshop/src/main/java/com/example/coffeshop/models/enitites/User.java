package com.example.coffeshop.models.enitites;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name= "users")
public class User extends BaseEntity{

    @Column(unique = true)
    @NotBlank
    private String username;
    @Column(name = "first_name", nullable = true)
    private String firstName;
    @Column(name = "last_name")
    @NotBlank
    private String lastName;
    @Column
    @NotBlank
    private String password;
    @Column(unique = true)
    @Email
    @NotBlank
    private String email;
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER)
    private List<Order> orders;

    public User() {
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
