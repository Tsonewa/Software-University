package com.example.coffeshop.models.enitites.bindings;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserLoginBidingModel {


    @NotBlank
    @Size(min = 5, max = 20)
    private String username;
    @NotBlank
    @Size(min = 3)
    private String password;

    public UserLoginBidingModel() {
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

}
