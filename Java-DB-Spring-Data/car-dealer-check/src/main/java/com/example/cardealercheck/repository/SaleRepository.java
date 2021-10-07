package com.example.cardealercheck.repository;

import com.example.cardealercheck.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findAllByDiscountNot(BigDecimal bigDecimal);

}
