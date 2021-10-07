package com.example.jsonproccessing.repos;

import com.example.jsonproccessing.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Set<Product> findAllByPriceBetweenAndBuyerIdIsNullOrderByPrice(BigDecimal lower, BigDecimal higher);

    List<Product> findAllByBuyerIdIsNotNull();
}
