package com.example.examprep2.web;

import com.example.examprep2.models.entities.Product;
import com.example.examprep2.models.enums.CategoryEnum;
import com.example.examprep2.services.ProductService;
import com.example.examprep2.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Set;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;
    private final ProductService productService;

    public HomeController(CurrentUser currentUser, ModelMapper modelMapper, ProductService productService) {
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(Model model){

        if(currentUser.getId() == null){
            return "index";
        }

        Set<Product> foodProducts = productService.findAllProductsByCategory(CategoryEnum.FOOD);
        Set<Product> drinkProducts = productService.findAllProductsByCategory(CategoryEnum.DRINK);
        Set<Product> householdProducts = productService.findAllProductsByCategory(CategoryEnum.HOUSEHOLD);
        Set<Product> otherProducts = productService.findAllProductsByCategory(CategoryEnum.OTHER);

        model.addAttribute("foods", foodProducts);
        model.addAttribute("drinks", drinkProducts);
        model.addAttribute("households", householdProducts);
        model.addAttribute("others", otherProducts);

        model.addAttribute("totalPrice", productService.findAllProducts()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal::add)
                .orElse(null));

        return "home";
    }
}
