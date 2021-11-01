package com.example.coffeshop.services;

import com.example.coffeshop.models.enitites.User;
import com.example.coffeshop.models.enitites.service.UserLoginServiceModel;
import com.example.coffeshop.models.enitites.service.UserRegisterServiceModel;
import com.example.coffeshop.models.enitites.view.UserViewModel;

import java.util.List;


public interface UserService {
    void registateUser(UserRegisterServiceModel userRegisterServiceModel);

    UserLoginServiceModel findUserByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);

    void logout();

    User findById(Long id);

    List<UserViewModel> findAllUsersNameCountOfOrders();
}


