package com.example.examprep2.web;

import com.example.examprep2.models.bidings.ProductAddBindingModel;
import com.example.examprep2.models.entities.Product;
import com.example.examprep2.models.service.ProductAddServiceModel;
import com.example.examprep2.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ModelMapper modelMapper;
    private final ProductService productService;

    public ProductController(ModelMapper modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @GetMapping("/add")
    public String getProduct(){

        return "product-add";
    }

    @ModelAttribute
    private ProductAddBindingModel productAddBindingModel(){
        return new ProductAddBindingModel();
    }

    @PostMapping("/add")
    public String addProduct(@Valid ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            return "redirect:add";

        }

        Product productByName = productService.findProductByName(productAddBindingModel.getName());

        if(productByName != null){
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            return "redirect:add";
        }

        productService
                .addProduct(modelMapper.map(productAddBindingModel, ProductAddServiceModel.class));

        return "redirect:/";
    }

    @GetMapping("/bought/{id}")
    public String buyProduct(@PathVariable Long id){

        productService.buyProduct(id);

        return "redirect:/";
    }

    @GetMapping("/all")
    public String buyAllProduct(){

        productService.buyAllProduct();

        return "redirect:/";
    }
}
