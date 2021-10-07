package com.example.hiberspring.service.impl;

import com.example.hiberspring.repository.EmployeeCardRepository;
import com.example.hiberspring.service.EmployeeCardService;
import com.example.hiberspring.util.FileUtil;
import com.example.hiberspring.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {


    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final EmployeeCardRepository employeeCardRepository;

    public EmployeeCardServiceImpl(Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, EmployeeCardRepository employeeCardRepository) {
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.employeeCardRepository = employeeCardRepository;
    }

    @Override
    public Boolean employeeCardsAreImported() {

        return employeeCardRepository.count() < 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return null;
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) {
        return null;
    }
}
