package com.example.xmlproductstore.controllers;

import com.example.xmlproductstore.services.CategoryService;
import com.example.xmlproductstore.services.ProductService;
import com.example.xmlproductstore.services.UserService;
import com.example.xmlproductstore.utils.XMLParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

import static com.example.xmlproductstore.constants.IOFilePaths.OUTPUT_FILES_PATH;

@Component
public class App implements CommandLineRunner {

   private final UserService userService;
   private final ProductService productService;
   private final CategoryService categoryService;
   private final BufferedReader bufferedReader;
   private final XMLParser xmlParser;

    public App(UserService userService, ProductService productService, CategoryService categoryService, BufferedReader bufferedReader, XMLParser xmlParser) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.bufferedReader = bufferedReader;
        this.xmlParser = xmlParser;
    }

    @Override
    public void run(String... args) throws Exception {

     seedData();

        while (true) {
            System.out.println("Enter the command here: ");
            String[] commands = bufferedReader.readLine().trim().split("\\|");
            switch (commands[0].toLowerCase()) {

                case "1" -> productsInRange();
                case "2" -> successfullySoldProducts();
                case "3" -> categoriesByProductsCount();
                case "4" -> usersAndProducts();
            }
            }
            }

    private void usersAndProducts() throws JAXBException {

        System.out.println("Please help me and kill this fuckin bug!!");

        xmlParser.writeToFile(OUTPUT_FILES_PATH + "users-products.xml",
                userService.getAllUsersWithProducts());

    }

    private void categoriesByProductsCount() throws JAXBException {

        xmlParser.writeToFile(OUTPUT_FILES_PATH + "categories-with-products.xml",
                categoryService.getAllCategoriesInfo());
    }

    private void successfullySoldProducts() throws JAXBException {

        xmlParser.writeToFile(OUTPUT_FILES_PATH + "successfully-sold-products.xml",
                userService.getAllUsersSuccsessfullySoldProduct());

    }

    private void productsInRange() throws JAXBException {

        xmlParser.writeToFile(OUTPUT_FILES_PATH + "products-range.xml",
                productService.getAllProductsWhitPRiceInRange(BigDecimal.valueOf(500L),
                        BigDecimal.valueOf(1000L)));
    }


    private void seedData() throws JAXBException, FileNotFoundException {

    userService.seedUsers();
    categoryService.seedCategories();
    productService.seedProducts();

    }
}