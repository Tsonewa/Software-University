package com.example.coffeshop.web.controllers;

import com.example.coffeshop.models.enitites.User;
import com.example.coffeshop.models.enitites.view.AddOrderViewModel;
import com.example.coffeshop.models.enitites.view.UserViewModel;
import com.example.coffeshop.services.OrderService;
import com.example.coffeshop.services.UserService;
import com.example.coffeshop.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;


    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){

        if(currentUser.getId() == null){
            return "index";
        }

        List<AddOrderViewModel> allORdersByPriceDesc = orderService.findAllORdersByPriceDesc();
        model.addAttribute("orders",allORdersByPriceDesc);
        model.addAttribute("totalTime", allORdersByPriceDesc
                .stream()
                .map(o -> o.getCategory().getTime())
                .reduce(Integer::sum)
                .orElse(0));


        List<UserViewModel> allUsersNameCountOfOrders = userService.findAllUsersNameCountOfOrders();

        model.addAttribute("employees", allUsersNameCountOfOrders);

        return "home";




    }
}
