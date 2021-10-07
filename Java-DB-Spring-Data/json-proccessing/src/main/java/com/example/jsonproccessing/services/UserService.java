package com.example.jsonproccessing.services;

import com.example.jsonproccessing.dtos.ProductsWithBuyerDto;
import com.example.jsonproccessing.entities.User;

import java.io.IOException;
import java.util.Set;

public interface UserService {
    void seedUsers() throws IOException;
    User findRandomUser();
    Set<ProductsWithBuyerDto> getAllBySOldProducts();
}
