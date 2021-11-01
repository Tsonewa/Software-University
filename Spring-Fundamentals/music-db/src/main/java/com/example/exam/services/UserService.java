package com.example.exam.services;


import com.example.exam.models.enitites.User;
import com.example.exam.models.enitites.service.UserLoginServiceModel;
import com.example.exam.models.enitites.service.UserRegisterServiceModel;

import java.util.Optional;

public interface UserService {


    void registateUser(UserRegisterServiceModel userRegisterServiceModel);

    UserLoginServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    User findById(Long id);
}



