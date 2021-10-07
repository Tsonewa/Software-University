package com.example.cardealercheck.service;

import com.example.cardealercheck.model.entity.Part;

import java.io.IOException;

public interface PartService {
    void seedData() throws IOException;
    Part getRandomPart();
}
