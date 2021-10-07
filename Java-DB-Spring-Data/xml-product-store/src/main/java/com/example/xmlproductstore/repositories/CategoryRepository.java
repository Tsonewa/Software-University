package com.example.xmlproductstore.repositories;


import com.example.xmlproductstore.dtos.CategoriesByProductsCountRootDto;
import com.example.xmlproductstore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    @Query("select c.name,count(p.name),avg(p.price),sum(p.price) from Product p join p.categories c group by c.name order by count (p.id) desc")
    @Query("select c from Product p join p.categories c group by c.name order by count (p.id) desc")
    Set<Category> findAllCatagories();
}
