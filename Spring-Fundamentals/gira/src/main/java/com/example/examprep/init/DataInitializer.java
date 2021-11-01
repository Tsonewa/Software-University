package com.example.examprep.init;

import com.example.examprep.services.ClassificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

        private final  ClassificationService classificationService;

    public DataInitializer(ClassificationService classificationService) {
        this.classificationService = classificationService;
    }

    @Override
    public void run(String... args) throws Exception {

        classificationService.initClassifications();

    }
}
