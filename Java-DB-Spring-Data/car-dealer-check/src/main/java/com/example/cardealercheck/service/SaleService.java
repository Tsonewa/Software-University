package com.example.cardealercheck.service;

import com.example.cardealercheck.model.dto.SaleDiscountCustomerDto;
import com.example.cardealercheck.model.entity.Sale;

import java.util.List;

public interface SaleService {
    void seedData();

    List<Sale> getAllSales();

    List<SaleDiscountCustomerDto> getAllSalesWithDiscount();
}
