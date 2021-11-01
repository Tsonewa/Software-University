package com.example.examprep2.repositories;

import com.example.examprep2.models.entities.User;
import com.example.examprep2.models.service.UserLoginServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsernameAndPassword(String username, String password);
}
