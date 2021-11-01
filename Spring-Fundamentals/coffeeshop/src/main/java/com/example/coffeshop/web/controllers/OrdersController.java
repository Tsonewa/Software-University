package com.example.coffeshop.web.controllers;

import com.example.coffeshop.models.enitites.bindings.AddOrderBindingModel;
import com.example.coffeshop.models.enitites.service.AddOrderServiceModel;
import com.example.coffeshop.services.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDateTime;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    private final OrderService orderService;
    private final ModelMapper modelMapper;


    public OrdersController(OrderService orderService, ModelMapper modelMapper) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addOrder(){

        return "order-add";
    }

    @ModelAttribute
    public AddOrderBindingModel addOrderBindingModel(){
        return new AddOrderBindingModel();
    }

    @PostMapping("/add")
    public String addOrder(@Valid AddOrderBindingModel addOrderBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("addOrderBindingModel", addOrderBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addOrderBindingModel", bindingResult);

            return "redirect:add";
        }

        AddOrderServiceModel order =
                modelMapper.map(addOrderBindingModel, AddOrderServiceModel.class);

        orderService.addOrder(order);

        return "home";

    }

    @GetMapping("/ready/{id}")
    public String readey(@PathVariable Long id){

        orderService.readyOrder(id);

        return "redirect:/";
    }


}
