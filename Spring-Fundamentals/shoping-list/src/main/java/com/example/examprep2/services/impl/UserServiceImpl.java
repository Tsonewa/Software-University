package com.example.examprep2.services.impl;

import com.example.examprep2.models.entities.User;
import com.example.examprep2.models.service.UserLoginServiceModel;
import com.example.examprep2.models.service.UserRegisterServiceModel;
import com.example.examprep2.repositories.UserRepository;
import com.example.examprep2.services.UserService;
import com.example.examprep2.util.CurrentUser;
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

        userRepository.save(modelMapper.map(userRegisterServiceModel, User.class));
    }

    @Override
    public UserLoginServiceModel findUserByUsernameAndPassword(String username, String password) {

        return userRepository.findUserByUsernameAndPassword(username, password)
                .map(u -> modelMapper.map(u, UserLoginServiceModel.class))
                .orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {

        currentUser.setUsername(username);
        currentUser.setId(id);
    }

    @Override
    public void logout() {
        currentUser.setId(null);
        currentUser.setUsername(null);
    }

    @Override
    public User findUserById(Long id) {

        return userRepository.findById(id).orElse(null);

    }
}

