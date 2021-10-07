package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.Car;
import softuni.exam.models.dtos.CarsSeedDto;
import softuni.exam.repository.CarRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CarServiceImpl implements CarService {

    public static final String CARS_INPUT_FILE_PATH = "src/main/resources/files/json/cars.json";

    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final CarRepository carRepository;
    private final ModelMapper modelMapper;

    public CarServiceImpl(ValidationUtil validationUtil, Gson gson, CarRepository carRepository, ModelMapper modelMapper) {
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {

      return  Files.readString(Path.of(CARS_INPUT_FILE_PATH)).trim();

    }

    @Override
    public String importCars() throws IOException {

      StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readCarsFileContent(), CarsSeedDto[].class))
                .filter(carsSeedDto -> {
                    boolean isValid = validationUtil.isValid(carsSeedDto);

                    sb.append(isValid ? String.format("Successfully imported %s - %s",
                            carsSeedDto.getMake(), carsSeedDto.getModel()) :
                            "Invalid car").append(System.lineSeparator());

                    return isValid;
                }).map(carsSeedDto -> modelMapper.map(carsSeedDto, Car.class))
                .forEach(carRepository::save);

        return sb.toString();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {

StringBuilder sb = new StringBuilder();

carRepository
        .findAllByByPictureCountAndMake()
        .forEach(car -> {

            sb.append(String.format(
                    "Car make - %s, model - %s\n" +
                    "\tKilometers - %d\n" +
                    "\tRegistered on - %s\n" +
                    "\tNumber of pictures - %d", car.getMake(), car.getModel()
            ,car.getKilometers(),car.getRegisteredOn(), car.getPictures().size()))
                    .append(System.lineSeparator());

        });
        return sb.toString();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository
                .findById(id).orElse(null);
    }
}
