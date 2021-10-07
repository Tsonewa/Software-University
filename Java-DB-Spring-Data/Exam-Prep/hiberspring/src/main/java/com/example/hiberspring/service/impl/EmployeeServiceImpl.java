package com.example.hiberspring.service.impl;

import com.example.hiberspring.repository.EmployeeRepository;
import com.example.hiberspring.service.EmployeeService;
import com.example.hiberspring.util.FileUtil;
import com.example.hiberspring.util.ValidationUtil;
import com.example.hiberspring.util.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final EmployeeRepository employeeRepository;
    private final XMLParser xmlParser;

    public EmployeeServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, EmployeeRepository employeeRepository, XMLParser xmlParser) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.employeeRepository = employeeRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public Boolean employeesAreImported() {


        return employeeRepository.count() < 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return null;
    }

    @Override
    public String importEmployees() throws JAXBException {
        return null;
    }

    @Override
    public String exportProductiveEmployees() {
        return null;
    }
}
