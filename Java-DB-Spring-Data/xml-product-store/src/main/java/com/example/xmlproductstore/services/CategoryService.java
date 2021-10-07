package com.example.xmlproductstore.services;

import com.example.xmlproductstore.dtos.CategoriesByProductsCountRootDto;
import com.example.xmlproductstore.entities.Category;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategories() throws JAXBException, FileNotFoundException;

    List<Category> getRandomCategories();

    CategoriesByProductsCountRootDto getAllCategoriesInfo();

    Category getRandomCategory();
}
