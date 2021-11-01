package com.example.examprep.reps;

import com.example.examprep.models.enitites.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

//    List<Order> findAllByOrderByPriceDesc();
}
