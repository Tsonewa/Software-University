package com.example.examprep2.services.impl;

import com.example.examprep2.models.entities.Category;
import com.example.examprep2.models.enums.CategoryEnum;
import com.example.examprep2.repositories.CategoryRepository;
import com.example.examprep2.services.CategoryService;
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

        if(categoryRepository.count() != 0){
            return;
        }

        Arrays.stream(CategoryEnum.values())
                .forEach(c -> {

                    Category category = new Category();
                    category.setName(c);

                    switch (c.name()){
                        case "FOOD":
                            category.setDescription("Description food");
                                break;
                        case "DRINK":
                            category.setDescription("Description drink");
                            break;
                        case "HOUSEHOLD":
                            category.setDescription("Description household");
                            break;
                        case "OTHER":
                            category.setDescription("Description other");
                            break;
                    }

                    categoryRepository.save(category);
                });

    }

    @Override
    public Category findCategoryByName(CategoryEnum category) {

        return categoryRepository.findByName(category);

    }
}
