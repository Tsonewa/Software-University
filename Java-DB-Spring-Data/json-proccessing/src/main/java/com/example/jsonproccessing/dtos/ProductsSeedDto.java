package com.example.jsonproccessing.dtos;

import com.google.gson.annotations.Expose;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Component
public class ProductsSeedDto {

    @Expose
    private String name;
    @Expose
    private BigDecimal price;

    public ProductsSeedDto() { }

    public ProductsSeedDto(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Size(min = 3)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Positive
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
