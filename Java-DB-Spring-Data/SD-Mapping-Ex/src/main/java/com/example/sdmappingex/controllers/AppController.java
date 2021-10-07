package com.example.sdmappingex.controllers;

import com.example.sdmappingex.dtos.UserRegisterDto;
import com.example.sdmappingex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AppController implements CommandLineRunner {

    private final UserService userService;

    @Autowired
    public AppController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);


        while (true){
            String[] params = sc.nextLine().split("\\|");

            switch (params[0]){
                case "RegisterUser":
                    UserRegisterDto userRegisterDto = new UserRegisterDto(params[1],
                            params[2], params[3], params[4]);
                    this.userService.registerUser(userRegisterDto);
                    break;
                case "LoginUser":
                    break;
                case "LogoutUser":
                    break;
                case "exit":
                    return;
            }
        }

    }
}
