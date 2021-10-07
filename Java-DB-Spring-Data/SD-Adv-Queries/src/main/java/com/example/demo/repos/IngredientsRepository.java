package com.example.demo.repos;

import com.example.demo.domain.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRepository  extends JpaRepository<Ingredient, Long> {
}
