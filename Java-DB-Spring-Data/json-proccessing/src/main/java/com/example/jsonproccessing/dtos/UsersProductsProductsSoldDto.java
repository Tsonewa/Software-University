package com.example.jsonproccessing.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersProductsProductsSoldDto {
    @Expose
    private Integer count;
    @Expose
    private List<UsersProductsProductsSoldDto> products;

    public UsersProductsProductsSoldDto() { }

    public UsersProductsProductsSoldDto(Integer count) {
        this.count = count;
        this.products = new ArrayList<>();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<UsersProductsProductsSoldDto> getProducts() {
        return products;
    }

    public void setProducts(List<UsersProductsProductsSoldDto> products) {
        this.products = products;
    }
}
