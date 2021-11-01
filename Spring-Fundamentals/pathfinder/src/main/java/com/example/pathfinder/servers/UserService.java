package com.example.pathfinder.servers;

import com.example.pathfinder.models.enums.service.UserLoginServiceModel;
import com.example.pathfinder.models.enums.service.UserRegisterServiceModel;
import com.example.pathfinder.models.enums.view.UserProfileViewModel;

public interface UserService {
    void registrateUser(UserRegisterServiceModel userRegisterServiceModel);

    <Optional>UserLoginServiceModel userExist(String username, String password);

    void loginUser(UserLoginServiceModel user);

    <Optional>UserProfileViewModel getUserProfile(String username);
}

