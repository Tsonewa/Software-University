package com.example.xmlproductstore.repositories;


import com.example.xmlproductstore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where (select count(p) from Product p where p.seller.id = u.id) > 0 order by u.lastName, u.firstName")
    Set<User> getAllBySoldProductsIsNotNullAndBuyerIsNotNull();

    @Query("select u from User u where (select count(p) from Product p where p.seller.id = u.id) > 0 order by  u.lastName")
    List<User> findAllUsersWithSoldProductsOrderedByNumberOfProductsDescAndLastName();
}
