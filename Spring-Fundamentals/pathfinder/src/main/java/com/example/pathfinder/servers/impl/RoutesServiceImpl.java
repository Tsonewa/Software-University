package com.example.pathfinder.servers.impl;

import com.example.pathfinder.models.enums.entities.Route;
import com.example.pathfinder.repos.RouteRepository;
import com.example.pathfinder.servers.RoutesService;
import com.example.pathfinder.models.enums.service.RoutesServiceModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoutesServiceImpl implements RoutesService {

    private final RouteRepository routeRepository;
    private final ModelMapper modelMapper;

    public RoutesServiceImpl(RouteRepository routeRepository, ModelMapper modelMapper) {
        this.routeRepository = routeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RoutesServiceModel> getAllRoutes() {

        List<Route> allNameAndDescription = routeRepository.findAllNameAndDescription();

        List<RoutesServiceModel> routes = new ArrayList<>();
        for (Route route: allNameAndDescription) {
           routes.add(modelMapper.map(route, RoutesServiceModel.class));
        }

        return routes;
    }
}


