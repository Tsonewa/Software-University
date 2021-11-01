package com.example.pathfinder.models.enums.entities;

import com.example.pathfinder.models.enums.Level;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column
    @Positive
    private Integer age;
    @Column(name = "full_name")
    private String fullName;

    @Column(nullable = false, unique = true)
    @Size(min = 2)
    private String username;
    @Column
//    @Pattern(regexp = "[a-zA-z@]+")
    @NotBlank
    private String password;
    @Column
    @Email
    private String email;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Role> role;
    @Enumerated(EnumType.STRING)
    private Level level;

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

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
