package com.example.coffeshop.models.enitites.view;

import com.example.coffeshop.models.enitites.Category;

import java.math.BigDecimal;

public class AddOrderViewModel {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;


    public AddOrderViewModel() {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
