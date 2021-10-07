package com.example.jsonproccessing.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;


@Component
public class UsersProductsUsersDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Integer age;
    @Expose
    private UsersProductsProductsSoldDto soldProducts;

    public UsersProductsUsersDto() { }

    public UsersProductsUsersDto(String firstName, String lastName, Integer age, UsersProductsProductsSoldDto soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.soldProducts = soldProducts;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UsersProductsProductsSoldDto getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(UsersProductsProductsSoldDto soldProducts) {
        this.soldProducts = soldProducts;
    }
}
