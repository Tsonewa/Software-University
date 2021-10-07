package com.example.cardealercheck.service;

import com.example.cardealercheck.model.dto.CustomerOrderedCapitalDto;
import com.example.cardealercheck.model.dto.CustomerTotalSalesDto;
import com.example.cardealercheck.model.entity.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
    void seedData() throws IOException;

    Customer getRandomCustomer();

    List<CustomerOrderedCapitalDto> getOrderedCustomers();

    List<CustomerTotalSalesDto> getCustomersWithTheirSales();
}
