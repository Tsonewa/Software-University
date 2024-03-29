package com.example.hiberspring.repository;

import com.example.hiberspring.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    Town getByName(String name);

    boolean existsByName(String name);
}
