package com.example.pathfinder.web;

import com.example.pathfinder.servers.RoutesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    private final RoutesService routesService;
    private final ModelMapper modelMapper;

    public RouteController(RoutesService routesService, ModelMapper modelMapper) {
        this.routesService = routesService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/routes")
    public String getRouts(Model model){

        model.addAttribute("routes",  routesService.getAllRoutes());

        return "routes";
    }
}
