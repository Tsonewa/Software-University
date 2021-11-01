package com.example.pathfinder.servers.impl;

import com.example.pathfinder.models.enums.entities.User;
import com.example.pathfinder.models.enums.service.UserLoginServiceModel;
import com.example.pathfinder.models.enums.service.UserRegisterServiceModel;
import com.example.pathfinder.models.enums.view.UserProfileViewModel;
import com.example.pathfinder.repos.UserRepository;
import com.example.pathfinder.servers.UserService;
import com.example.pathfinder.utils.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void registrateUser(UserRegisterServiceModel userRegisterServiceModel) {

        if(userRepository.findUserByUsername(userRegisterServiceModel.getUsername()) == null){
            // Continues is user with that username doesn't exist in the DB

            User newUser = modelMapper
                    .map(userRegisterServiceModel, User.class);

            userRepository.save(newUser);

        }
    }

    @Override
    public void loginUser(UserLoginServiceModel user) {

        currentUser.setUsername(user.getUsername());
        currentUser.setPassword(user.getPassword());
    }

    @Override
    public UserProfileViewModel getUserProfile(String username) {

        User userByUsername = userRepository.findUserByUsername(username);

        UserProfileViewModel user = modelMapper.map(userByUsername, UserProfileViewModel.class);

        user.setLevel(userByUsername.getLevel());

        return user;
    }


    @Override
    public UserLoginServiceModel userExist(String username, String password) {
        User user = userRepository.findUserByUsernameAndPassword
                (username, password);

        return user != null ? modelMapper.map(user, UserLoginServiceModel.class) : null;
    }


}
