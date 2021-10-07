package com.example.airlpane.repository;


import com.example.airlpane.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    @Query("select p from Passenger p order by count(p.tickets.size) desc, p.email")
    List<Passenger> findAllPassengersAndTheirTicketCount();
    
}
