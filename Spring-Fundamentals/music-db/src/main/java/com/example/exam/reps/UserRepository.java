package com.example.exam.reps;


import com.example.exam.models.enitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.validation.constraints.NotBlank;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findUserByUsernameAndPassword(@NotBlank String username, @NotBlank String password);

//    @Query("select u from User u order by u.orders.size")
//    List<User> findAllUsersNameAndOrderCount();


}
