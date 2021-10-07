package com.example.cardealercheck.service;

import com.example.cardealercheck.model.dto.CarsAndParts;
import com.example.cardealercheck.model.dto.CarsToyotaDto;
import com.example.cardealercheck.model.entity.Car;

import java.io.IOException;
import java.util.List;

public interface CarService {

    void seedData() throws IOException;

    Car getRandomCar();

    List<CarsToyotaDto> getCarsFromMakeToyota(String make);

    List<CarsAndParts> getCarsAndParts();
}
