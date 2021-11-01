package com.example.coffeshop.services;

import com.example.coffeshop.models.enitites.Category;
import com.example.coffeshop.models.enitites.enums.CategoryEnum;

public interface CategoryService {

    void initCategories();

    Category findByCategoryName(CategoryEnum category);
}

