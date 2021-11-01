package com.example.examprep2.repositories;

import com.example.examprep2.models.entities.Category;
import com.example.examprep2.models.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(CategoryEnum category);
}
