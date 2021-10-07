package com.example.sdmappingex.services;

import com.example.sdmappingex.dtos.UserRegisterDto;

public interface UserService{

    String registerUser(UserRegisterDto userRegisterDto);
}
