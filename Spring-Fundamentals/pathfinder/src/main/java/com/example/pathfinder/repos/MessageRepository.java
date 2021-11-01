package com.example.pathfinder.repos;

import com.example.pathfinder.models.enums.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
}
