package com.example.examprep2.services;

import com.example.examprep2.models.entities.User;
import com.example.examprep2.models.service.UserLoginServiceModel;
import com.example.examprep2.models.service.UserRegisterServiceModel;

import java.util.Optional;

public interface UserService {
    void registrateUser(UserRegisterServiceModel userRegisterServiceModel);

    UserLoginServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
    void logout();

    User findUserById(Long id);
}



