package com.example.jsonproccessing.repos;

import com.example.jsonproccessing.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Categories, Long> {

    @Query("select c.name,count(p.name),avg(p.price),sum(p.price) from Product p join p.categories c group by c.name order by count (p.id) desc")
    List<Object[]> findAllCatagories();
}
