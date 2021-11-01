package com.example.pathfinder.repos;

import com.example.pathfinder.models.enums.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {

    @Query("SELECT r.name, r.description FROM Route r")
    List<Route> findAllNameAndDescription();

}
