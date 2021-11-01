package com.example.pathfinder.models.enums.view;

import com.example.pathfinder.models.enums.Level;

public class UserProfileViewModel {

    private Level level;
    private String fullName;
    private String username;
    private Integer age;

    public UserProfileViewModel() {
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
