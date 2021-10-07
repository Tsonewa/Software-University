package com.example.demo.repos;

import com.example.demo.domain.entities.Shampoo;
import com.example.demo.domain.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    @Query("select s from Shampoo as s where s.brand like %:brand%")
    List<Shampoo> searchByBrand(String brand);

    List<Shampoo> findShampooBySizeOrderById(Size size);
}
