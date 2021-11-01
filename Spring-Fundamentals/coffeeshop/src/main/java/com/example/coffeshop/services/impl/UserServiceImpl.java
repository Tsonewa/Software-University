package com.example.coffeshop.services.impl;

import com.example.coffeshop.models.enitites.User;
import com.example.coffeshop.models.enitites.service.UserLoginServiceModel;
import com.example.coffeshop.models.enitites.service.UserRegisterServiceModel;
import com.example.coffeshop.models.enitites.view.UserViewModel;
import com.example.coffeshop.reps.UserRepository;
import com.example.coffeshop.services.UserService;
import com.example.coffeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }


    @Override
    public void registateUser(UserRegisterServiceModel userRegisterServiceModel) {

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
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUsersNameCountOfOrders() {
        return userRepository.findAllUsersNameAndOrderCount()
                .stream()
                .map(u -> {

                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(u.getUsername());
                    userViewModel.setCountOfOrders(u.getOrders().size());

                    return userViewModel;
                })
                .collect(Collectors.toList());
    }
}
