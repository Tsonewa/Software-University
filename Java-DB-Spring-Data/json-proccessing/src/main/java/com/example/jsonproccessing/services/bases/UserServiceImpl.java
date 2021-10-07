package com.example.jsonproccessing.services.bases;

import com.example.jsonproccessing.dtos.ProductsWithBuyerDto;
import com.example.jsonproccessing.dtos.UserSeedDto;
import com.example.jsonproccessing.entities.User;
import com.example.jsonproccessing.repos.UserRepository;
import com.example.jsonproccessing.services.UserService;
import com.example.jsonproccessing.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.jsonproccessing.constants.Const.USERS_SEED_FILE_PATH;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedUsers() throws IOException {

        if(userRepository.count() > 0){
            return;
        }

        String data = Files.readString(Path.of(USERS_SEED_FILE_PATH));

        Arrays.stream(gson.fromJson(data, UserSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(m -> modelMapper.map(m, User.class))
                .forEach(userRepository::save);
    }

    @Override
    public User findRandomUser() {

        return userRepository
                .findById(ThreadLocalRandom.current().
                        nextLong(1, userRepository.findAll().size()))
                .orElse(null);
    }

    @Override
    public Set<ProductsWithBuyerDto> getAllBySOldProducts() {

        return userRepository
                .getAllBySoldProductsIsNotNullAndBuyerIsNotNull()
                .stream()
                .map(m -> modelMapper.map(m, ProductsWithBuyerDto.class))
                .collect(Collectors.toSet());

    }
}
