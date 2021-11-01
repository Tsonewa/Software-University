package com.example.coffeshop.services.impl;

import com.example.coffeshop.models.enitites.Category;
import com.example.coffeshop.models.enitites.enums.CategoryEnum;
import com.example.coffeshop.reps.CategoryRepository;
import com.example.coffeshop.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {

        if(categoryRepository.count() == 0) {

            Arrays.stream(CategoryEnum.values())
                    .forEach(c -> {
                        Category category = new Category();
                        category.setName(c.name());
                        switch (c.name()) {
                            case "COFFEE":
                                category.setTime(2);
                                break;
                            case "DRINK":
                                category.setTime(1);
                                break;
                            case "OTHER":
                                category.setTime(5);
                                break;
                            case "CAKE":
                                category.setTime(10);
                                break;
                        }

                        categoryRepository.save(category);

                    });
        }
    }

    @Override
    public Category findByCategoryName(CategoryEnum category) {
        return categoryRepository.findCategoryByName(category.name()).orElse(null);
    }


}
