package com.example.examprep2.models.entities;

import com.example.examprep2.models.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name= "users")
public class User extends BaseEntity {

    @Column(unique = true)
    @NotBlank
    private String username;
    @Column
    @NotBlank
    private String password;
    @Column
    @Email
    @NotBlank
    private String email;
    @OneToMany(mappedBy = "user", targetEntity = Product.class)
    private Set<Product> products;

    public User() {
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
