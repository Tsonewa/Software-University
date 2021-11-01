package com.example.pathfinder.servers;

import com.example.pathfinder.models.enums.service.RoutesServiceModel;

import java.util.List;


public interface RoutesService {

    List<RoutesServiceModel> getAllRoutes();
}

