package com.example.examprep.services.impl;

import com.example.examprep.models.enitites.User;
import com.example.examprep.models.enitites.service.UserLoginServiceModel;
import com.example.examprep.models.enitites.service.UserRegisterServiceModel;
import com.example.examprep.reps.UserRepository;
import com.example.examprep.services.UserService;
import com.example.examprep.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public User findUserByEmail(String email) {

        return userRepository.findByEmail(email);

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
    public UserLoginServiceModel findUserByEmailAndPassword(String email, String password) {

        return userRepository.findUserByEmailAndPassword(email, password)
                .map(a -> modelMapper.map(a, UserLoginServiceModel.class))
                .orElse(null);


    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

//    @Override
//    public List<UserViewModel> findAllUsersNameCountOfOrders() {
//        return userRepository.findAllUsersNameAndOrderCount()
//                .stream()
//                .map(u -> {
//
//                    UserViewModel userViewModel = new UserViewModel();
//                    userViewModel.setUsername(u.getUsername());
//                    userViewModel.setCountOfOrders(u.getOrders().size());
//
//                    return userViewModel;
//                })
//                .collect(Collectors.toList());
//    }
}
