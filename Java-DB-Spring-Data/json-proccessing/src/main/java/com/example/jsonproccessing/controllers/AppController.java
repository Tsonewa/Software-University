package com.example.jsonproccessing.controllers;

import com.example.jsonproccessing.services.CategoryService;
import com.example.jsonproccessing.services.ProductService;
import com.example.jsonproccessing.services.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

import static com.example.jsonproccessing.constants.Const.*;

@Controller
public class AppController implements CommandLineRunner {

    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;
    private final Gson gson;

    public AppController(CategoryService categoryService, UserService userService, ProductService productService, BufferedReader bufferedReader, Gson gson) {
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        this.bufferedReader = bufferedReader;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {
      seedData();

      while (true){

        System.out.println("Enter exercise number: ");
        String command = bufferedReader.readLine();

        switch (command){
            case "1" -> productsInRange();
            case "2" -> successfullySoldProducts();
            case "3" -> categoriesBuPRoductsCount();
            case "4" -> getAllSellersAndTheirProducts();
        }
      }
    }

    private void getAllSellersAndTheirProducts() throws IOException {

        writeToFile(OUTPUT_FILES_PATH
                        + USERS_AND_PRODUCTS_OUTPUT,
                gson.toJson(productService.getSellersAndTheirProducts()));
    }

    private void categoriesBuPRoductsCount() throws IOException {

        writeToFile(OUTPUT_FILES_PATH
                + PRODUCT_COUNT_OUTPUT,
                gson.toJson(categoryService.getCategoriesByProductsCount()));
    }

    private void productsInRange() throws IOException {

         writeToFile(OUTPUT_FILES_PATH
                    + PRODUCT_CATEGORY_OUTPUT, gson.toJson(productService
                .getProductsInRange(BigDecimal.valueOf(500L),
                        BigDecimal.valueOf(1000L))));
    }

    private void successfullySoldProducts() throws IOException {

        writeToFile(OUTPUT_FILES_PATH
                + PRODUCT_SOLD_OUTPUT, gson.toJson(userService
                .getAllBySOldProducts()));

    }

    private void writeToFile(String outputFilesPath, String data) throws IOException {

      Files.write(Path.of(outputFilesPath), Collections.singleton(data));
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        userService.seedUsers();
        productService.seedProducts();
    }
}

--------------------------------------------------------------------

@Override
    public User findRandomUser() {

        return userRepository
                .findById(ThreadLocalRandom.current().
                        nextLong(1, userRepository.findAll().size()))
                .orElse(null);
    }

-------------------------------------------------------------------------
