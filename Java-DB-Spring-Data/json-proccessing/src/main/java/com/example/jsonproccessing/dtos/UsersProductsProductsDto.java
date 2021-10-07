package com.example.jsonproccessing.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UsersProductsProductsDto {
    @Expose
   private String name;
   @Expose
    private BigDecimal price;

    public UsersProductsProductsDto() { }

    public UsersProductsProductsDto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
