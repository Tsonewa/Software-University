package com.example.pathfinder.models.enums.service;

import com.example.pathfinder.models.enums.Level;
import com.example.pathfinder.models.enums.entities.Role;

import java.util.Set;

public class UserRegisterServiceModel {

    private Integer age;
    private String fullName;
    private String username;
    private String password;
    private String email;
    private Set<Role> role;
    private Level level;

    public UserRegisterServiceModel() {
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
}
