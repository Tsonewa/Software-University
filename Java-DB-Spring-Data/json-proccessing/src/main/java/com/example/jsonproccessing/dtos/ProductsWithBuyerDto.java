package com.example.jsonproccessing.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ProductsWithBuyerDto {

    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private Set<ProductsSoldDto> soldProducts;

    public ProductsWithBuyerDto() { }

    public ProductsWithBuyerDto(String firstName, String lastName, Set<ProductsSoldDto> soldProducts) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public Set<ProductsSoldDto> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(Set<ProductsSoldDto> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
