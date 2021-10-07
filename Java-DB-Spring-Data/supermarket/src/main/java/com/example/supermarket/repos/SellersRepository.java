package com.example.supermarket.repos;

import com.example.supermarket.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellersRepository extends JpaRepository<Seller, UUID> {
}
