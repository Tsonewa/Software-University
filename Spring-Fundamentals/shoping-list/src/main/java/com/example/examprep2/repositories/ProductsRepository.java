package com.example.examprep2.repositories;

import com.example.examprep2.models.entities.Category;
import com.example.examprep2.models.entities.Product;
import com.example.examprep2.models.enums.CategoryEnum;
import com.example.examprep2.models.service.ProductAddServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);

    Set<Product> findAllByCategoryName(CategoryEnum category);

}
