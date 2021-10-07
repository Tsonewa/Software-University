package com.example.airlpane.service.impl;

import com.example.airlpane.models.Passenger;
import com.example.airlpane.models.dtos.PassengerSeedDto;
import com.example.airlpane.service.TownService;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.example.airlpane.repository.PassengerRepository;
import com.example.airlpane.service.PassengerService;
import com.example.airlpane.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {

    public static final String PASSENGER_FILE_PATH = "src/main/resources/files/json/passengers.json";

    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final PassengerRepository passengerRepository;
    private final TownService townService;

    public PassengerServiceImpl(ValidationUtil validationUtil, Gson gson, ModelMapper modelMapper, PassengerRepository passengerRepository, TownService townService) {
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.passengerRepository = passengerRepository;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {

        return passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {

        return Files.readString(Path.of(PASSENGER_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readPassengersFileContent(), PassengerSeedDto[].class))
                .filter(passengerSeedDto -> {
                    boolean isValid = validationUtil.isValid(passengerSeedDto);

                    sb.append(isValid ? String.format("Successfully imported Passenger %s - %s",
                            passengerSeedDto.getFirstname(),
                            passengerSeedDto.getEmail()) :
                            "Invalid Passenger")
                            .append(System.lineSeparator());

                    return isValid;
                }).map(passengerSeedDto -> {
            Passenger passenger = modelMapper.map(passengerSeedDto, Passenger.class);

            passenger.setTown(townService.getTownByName(passengerSeedDto.getTown()));


            return passenger;
        })
                .forEach(passengerRepository::save);

        return sb.toString();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {

        StringBuilder sb = new StringBuilder();

        passengerRepository.findAllPassengersAndTheirTicketCount()
                .forEach(p -> {

                    sb.append(String.format("Passenger %s %s",
                            p.getFirstName(), p.getLastName()))
                            .append(System.lineSeparator())
                            .append(String.format("\tEmail - %s",
                                    p.getEmail()))
                            .append(System.lineSeparator())
                            .append(String.format("\tPhone - %s",
                                    p.getPhoneNumber()))
                            .append(System.lineSeparator())
                            .append(String.format("\tNumber of tickets: %d",
                                    p.getTickets().size()))
                            .append(System.lineSeparator());

                });

        return sb.toString();

    }
}
