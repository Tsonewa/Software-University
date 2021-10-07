package com.example.jsonproccessing.dtos;

import com.example.jsonproccessing.entities.User;
import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPriceBetweenDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private String seller;

    public ProductPriceBetweenDto() { }

    public ProductPriceBetweenDto(String name, BigDecimal price, String seller) {
        this.name = name;
        this.price = price;
        this.seller = seller;
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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
