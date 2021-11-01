package com.example.examprep2.services;

import com.example.examprep2.models.entities.Category;
import com.example.examprep2.models.enums.CategoryEnum;

public interface CategoryService {
    void initCategories();

    Category findCategoryByName(CategoryEnum category);
}


