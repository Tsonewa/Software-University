package com.example.coffeshop.services;

import com.example.coffeshop.models.enitites.service.AddOrderServiceModel;
import com.example.coffeshop.models.enitites.view.AddOrderViewModel;

import java.util.List;

public interface OrderService {
    void addOrder(AddOrderServiceModel order);

    List<AddOrderViewModel> findAllORdersByPriceDesc();

    void readyOrder(Long id);
}


