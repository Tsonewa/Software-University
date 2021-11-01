package com.example.examprep2.services.impl;

import com.example.examprep2.models.entities.Product;
import com.example.examprep2.models.enums.CategoryEnum;
import com.example.examprep2.models.service.ProductAddServiceModel;
import com.example.examprep2.repositories.ProductsRepository;
import com.example.examprep2.services.CategoryService;
import com.example.examprep2.services.ProductService;
import com.example.examprep2.services.UserService;
import com.example.examprep2.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductsRepository productsRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;
    private final UserService userService;

    public ProductServiceImpl(ProductsRepository productsRepository, ModelMapper modelMapper, CurrentUser currentUser, CategoryService categoryService, UserService userService) {
        this.productsRepository = productsRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void addProduct(ProductAddServiceModel productAddServiceModel) {

        Product currProduct = modelMapper.map(productAddServiceModel, Product.class);

        currProduct.setCategory(categoryService.findCategoryByName(productAddServiceModel.getCategory()));
        currProduct.setUser(userService.findUserById(currentUser.getId()));

        productsRepository.save(currProduct);
    }

    @Override
    public Product findProductByName(String name) {

        return productsRepository.findByName(name).orElse(null);
    }

    @Override
    public Set<Product> findAllProductsByCategory(CategoryEnum category) {

        return productsRepository.findAllByCategoryName(category);
    }

    @Override
    public List<Product> findAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void buyProduct(Long id) {

        productsRepository.deleteById(id);
    }

    @Override
    public void buyAllProduct() {

        productsRepository.deleteAll();
    }
}
