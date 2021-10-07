package com.example.airlpane.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.airlpane.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    Ticket findBySerialNumber(String serialNumber);

    boolean existsTicketByFromTownName(String name);

    boolean existsBySerialNumber(String serialNumber);




}
