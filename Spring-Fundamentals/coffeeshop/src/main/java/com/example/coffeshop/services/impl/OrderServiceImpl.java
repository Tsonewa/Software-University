package com.example.coffeshop.services.impl;

import com.example.coffeshop.models.enitites.Order;
import com.example.coffeshop.models.enitites.service.AddOrderServiceModel;
import com.example.coffeshop.models.enitites.view.AddOrderViewModel;
import com.example.coffeshop.reps.OrderRepository;
import com.example.coffeshop.services.CategoryService;
import com.example.coffeshop.services.OrderService;
import com.example.coffeshop.services.UserService;
import com.example.coffeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final CategoryService categoryService;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, CurrentUser currentUser, UserService userService, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addOrder(AddOrderServiceModel order) {
        Order currOrder = modelMapper.map(order, Order.class);
        currOrder.setEmployee(userService.findById(currentUser.getId()));
        currOrder.setCategory(categoryService.findByCategoryName(order.getCategory()));

        orderRepository.save(currOrder);
    }

    @Override
    public List<AddOrderViewModel> findAllORdersByPriceDesc() {
        return orderRepository.findAllByOrderByPriceDesc()
                .stream()
                .map(o -> modelMapper.map(o, AddOrderViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void readyOrder(Long id) {

        orderRepository.deleteById(id);
    }
}
