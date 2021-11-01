package com.example.examprep.models.enitites;

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
    @Column
    @NotBlank
    private String password;
    @Column(unique = true)
    @Email
    private String email;

    public User() {
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
