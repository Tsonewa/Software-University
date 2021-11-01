package com.example.examprep.services;

import com.example.examprep.models.enitites.Classification;
import com.example.examprep.models.enitites.enums.ClassificationNameEnum;

public interface ClassificationService {
    void initClassifications();

    Classification findClassificationByName(ClassificationNameEnum classificationName);

}

