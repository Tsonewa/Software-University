package com.example.examprep.services.impl;

import com.example.examprep.models.enitites.Classification;
import com.example.examprep.models.enitites.enums.ClassificationNameEnum;
import com.example.examprep.reps.ClassificationRepository;
import com.example.examprep.services.ClassificationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ClassificationServiceImpl implements ClassificationService {
    public ClassificationServiceImpl(ClassificationRepository classificationRepository) {
        this.classificationRepository = classificationRepository;
    }

    private final ClassificationRepository classificationRepository;


    @Override
    public void initClassifications() {

        if(classificationRepository.count() == 0) {

            Arrays.stream(ClassificationNameEnum.values())
                    .forEach(c -> {
                        Classification classification = new Classification();
                        classification.setClassificationName(c);
                        switch (c.name()) {
                            case "UG":
                                classification.setDescription("UG description");
                                break;
                            case "FEATURE":
                                classification.setDescription("FEAUTURE description");
                                break;
                            case "OTHER":
                                classification.setDescription("Other despription");
                                break;
                            case "SUPPORT":
                                classification.setDescription("SUPOORT description");
                                break;
                        }

                        classificationRepository.save(classification);

                    });
        }
    }

    @Override
    public Classification findClassificationByName(ClassificationNameEnum classificationName) {

        return classificationRepository.findByClassificationName(classificationName);

    }

//    @Override
//    public Category findByCategoryName(CategoryEnum category) {
//        return categoryRepository.findCategoryByName(category.name()).orElse(null);
//    }


}
