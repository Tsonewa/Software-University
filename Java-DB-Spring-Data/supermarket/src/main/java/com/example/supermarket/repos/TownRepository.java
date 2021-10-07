package com.example.supermarket.repos;

import com.example.supermarket.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TownRepository extends JpaRepository<Town, UUID> {
}
