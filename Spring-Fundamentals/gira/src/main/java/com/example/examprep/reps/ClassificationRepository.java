package com.example.examprep.reps;

import com.example.examprep.models.enitites.Classification;
import com.example.examprep.models.enitites.enums.ClassificationNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {

    Classification findByClassificationName(@NotNull ClassificationNameEnum classificationName);
//    Optional<Category> findCategoryByName(String name);
}
