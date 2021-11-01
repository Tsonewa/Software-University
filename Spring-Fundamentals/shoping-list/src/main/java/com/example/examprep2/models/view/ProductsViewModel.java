package com.example.examprep2.models.view;

import com.example.examprep2.models.enums.CategoryEnum;

public class ProductsViewModel {

    private String name;
    private String price;
    private CategoryEnum category;

    public ProductsViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
