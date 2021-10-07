package com.example.sdmappingex.services.bases;

import com.example.sdmappingex.dtos.UserRegisterDto;
import com.example.sdmappingex.entities.Role;
import com.example.sdmappingex.entities.User;
import com.example.sdmappingex.repos.UserRepository;
import com.example.sdmappingex.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String registerUser(UserRegisterDto userRegisterDto) {
        StringBuilder sb = new StringBuilder();

        User user = this.modelMapper.map(userRegisterDto, User.class);
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<User>> validate = validator.validate(user);

        if(validate.size() > 0) {
            for (ConstraintViolation<User> userValidation : validate) {
                sb.append(userValidation.getMessage());
            }
        }else {
            if (this.userRepository.count() == 0){
                user.setRole(Role.ADMIN);
            }else {
                user.setRole(Role.USER);
            }
            sb.append(String.format("%s was registered", user.getFullName()));
            this.userRepository.saveAndFlush(user);
        }
        return sb.toString();
    }
}
