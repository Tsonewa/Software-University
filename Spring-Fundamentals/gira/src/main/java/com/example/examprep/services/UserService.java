package com.example.examprep.services;

import com.example.examprep.models.enitites.User;
import com.example.examprep.models.enitites.service.UserLoginServiceModel;
import com.example.examprep.models.enitites.service.UserRegisterServiceModel;


public interface UserService {
    void registateUser(UserRegisterServiceModel userRegisterServiceModel);


    User findUserByEmail(String email);


    void loginUser(Long id, String email);

    void logout();

    UserLoginServiceModel findUserByEmailAndPassword(String email, String password);

    User findUserById(Long id);

//    List<UserViewModel> findAllUsersNameCountOfOrders();
}


