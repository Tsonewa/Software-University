package com.example.jsonproccessing.services;

import com.example.jsonproccessing.dtos.CaterogiesInfoDto;
import com.example.jsonproccessing.entities.Categories;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws IOException;

    Set<Categories> getRandomCategory();

    List<CaterogiesInfoDto> getCategoriesByProductsCount();
}

