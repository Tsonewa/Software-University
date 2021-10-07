package com.example.xmlproductstore.services;

import com.example.xmlproductstore.dtos.UsersProductsRootDto;
import com.example.xmlproductstore.dtos.UsersSoldPRoductsRootDto;
import com.example.xmlproductstore.entities.User;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public interface UserService {

    void seedUsers() throws JAXBException, FileNotFoundException;

    User getRandomSeller();
    User getRandomBuyer();

    UsersSoldPRoductsRootDto getAllUsersSuccsessfullySoldProduct();

    UsersProductsRootDto getAllUsersWithProducts();
}
