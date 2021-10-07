package com.example.football.repository;


import com.example.football.domain.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select p from Player p where p.team.name = 'North Hub' order by p.id")
    List<Player> getAllByTeamName();

    List<Player> getAllBySalaryIsGreaterThanOrderBySalaryDesc(BigDecimal salary);

}

