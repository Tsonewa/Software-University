package com.example.pathfinder.repos;

import com.example.pathfinder.models.enums.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}
