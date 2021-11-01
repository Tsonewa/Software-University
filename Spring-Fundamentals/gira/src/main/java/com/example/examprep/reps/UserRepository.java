package com.example.examprep.reps;

import com.example.examprep.models.enitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmailAndPassword(@NotBlank String email, @NotBlank String password);

    User findByEmail(String email);
//
//    @Query("select u from User u order by u.orders.size")
//    List<User> findAllUsersNameAndOrderCount();
}
