package com.example.examprep2.services;

import com.example.examprep2.models.entities.Product;
import com.example.examprep2.models.enums.CategoryEnum;
import com.example.examprep2.models.service.ProductAddServiceModel;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProductService {
    void addProduct(ProductAddServiceModel productAddServiceModel);

    Product findProductByName(String name);

    Set<Product> findAllProductsByCategory(CategoryEnum category);

    List<Product> findAllProducts();

    void buyProduct(Long id);

    void buyAllProduct();
}



