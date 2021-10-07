package com.example.airlpane.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.airlpane.models.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Long> {

    Plane findPlaneByRegisterNumber(String registerNumber);

}
