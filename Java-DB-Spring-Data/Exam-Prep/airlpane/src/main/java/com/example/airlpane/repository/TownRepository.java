package com.example.airlpane.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.airlpane.models.Town;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    boolean existsByName(String name);

    Town findByName(String name);

}
