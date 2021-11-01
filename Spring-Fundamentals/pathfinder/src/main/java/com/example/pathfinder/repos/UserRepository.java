package com.example.pathfinder.repos;

import com.example.pathfinder.models.enums.bidings.UserLoginBidingModel;
import com.example.pathfinder.models.enums.entities.User;
import com.example.pathfinder.models.enums.service.UserLoginServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findUserByUsername(String username);

    <Optional> User findUserByUsernameAndPassword(@Size(min = 2) String username, @NotBlank String password);

}
