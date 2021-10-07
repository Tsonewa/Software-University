package com.example.jsonproccessing.services;

import com.example.jsonproccessing.dtos.ProductPriceBetweenDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Set;

public interface ProductService {
    void seedProducts() throws IOException;

    Set<ProductPriceBetweenDto> getProductsInRange(BigDecimal lower, BigDecimal higher);

    String getSellersAndTheirProducts();
}


