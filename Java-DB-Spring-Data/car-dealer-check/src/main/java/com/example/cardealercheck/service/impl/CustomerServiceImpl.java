package com.example.cardealercheck.service.impl;

import com.example.cardealercheck.model.dto.*;
import com.example.cardealercheck.model.entity.Car;
import com.example.cardealercheck.model.entity.Customer;
import com.example.cardealercheck.model.entity.Part;
import com.example.cardealercheck.model.entity.Sale;
import com.example.cardealercheck.repository.CarRepository;
import com.example.cardealercheck.repository.CustomerRepository;
import com.example.cardealercheck.repository.SaleRepository;
import com.example.cardealercheck.service.CustomerService;
import com.example.cardealercheck.util.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.cardealercheck.constants.GlobalApplicationConstants.FILE_PATH_READ;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final CarRepository carRepository;
    private final SaleRepository saleRepository;

    public CustomerServiceImpl(Gson gson, ValidationUtil validationUtil,
                               ModelMapper modelMapper, CustomerRepository customerRepository, CarRepository carRepository, SaleRepository saleRepository) {
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
        this.carRepository = carRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public void seedData() throws IOException {
        if (this.customerRepository.count() > 0) {
            return;
        }

        String data = Files.readString(Path.of(FILE_PATH_READ + "customers.json"));

        CustomerSeedDto[] customerSeedDtos = gson.fromJson(data, CustomerSeedDto[].class);

        Arrays.stream(customerSeedDtos)
                .filter(validationUtil::isValid)
                .map(customerSeedDto -> {
                    Customer customer = modelMapper.map(customerSeedDto, Customer.class);
                    customer.setBirthDate(LocalDateTime.parse(customerSeedDto.getBirthDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
                    return customer;
                })
                .forEach(customerRepository::save);
    }

    @Override
    public Customer getRandomCustomer() {
        long count = this.customerRepository.count() + 1;
        long randomId = ThreadLocalRandom.current().nextLong(1, count + 1);

        return this.customerRepository.findById(randomId).orElse(null);

    }

    @Override
    public List<CustomerOrderedCapitalDto> getOrderedCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<Customer> orderedCustomers = customers.stream().sorted(Comparator.comparing(Customer::getBirthDate).thenComparing(Customer::getYoungDriver)).collect(Collectors.toList());
        List<CustomerOrderedCapitalDto> customerOrderedCapitalDtos = orderedCustomers.stream()
                .map(customer -> {
                    CustomerOrderedCapitalDto customerOrderedCapitalDto = modelMapper.map(customer, CustomerOrderedCapitalDto.class);
                    List<SalesCarMakeModelDto> salesCarMakeModelDtos = customer.getSales().stream()
                            .map(sale -> {
                                SalesCarMakeModelDto salesCarMakeModelDto = modelMapper.map(sale, SalesCarMakeModelDto.class);
                                salesCarMakeModelDto.setCar(sale.getCar().getMake() + " " + sale.getCar().getModel());
                                return salesCarMakeModelDto;
                            }).collect(Collectors.toList());
                    customerOrderedCapitalDto.setSales(salesCarMakeModelDtos);
                    return customerOrderedCapitalDto;
                })
                .collect(Collectors.toList());
        return customerOrderedCapitalDtos;
    }

    @Override
    public List<CustomerTotalSalesDto> getCustomersWithTheirSales() {
        List<Car> cars = carRepository.findAllSoldCars();

        List<Customer> customers = customerRepository.findAllBySalesIsNotNull();
        List<CustomerTotalSalesDto> customerTotalSalesDtos = customers.stream()
                .map(customer -> {
                    CustomerTotalSalesDto customerTotalSalesDto = modelMapper.map(customer, CustomerTotalSalesDto.class);
                    customerTotalSalesDto.setFullName(customer.getName());
                    customerTotalSalesDto.setBoughtCars(customer.getSales().size());
                    List<Car> carsPerCustomer = customer.getSales().stream().map(Sale::getCar).collect(Collectors.toList());
                    customerTotalSalesDto.setCars(carsPerCustomer);
                    List<Sale> sales = customer.getSales();
                    List<SalePriceDto> salePriceDtos = getSalePriceDtos(sales);
                    customerTotalSalesDto.setSales(salePriceDtos);

                    customerTotalSalesDto.setPrice(salePriceDtos.stream()
                    .map(SalePriceDto::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add));

                    return customerTotalSalesDto;
                }).collect(Collectors.toList());
        return customerTotalSalesDtos.stream()
                .sorted((f, s) -> s.getBoughtCars().compareTo(f.getBoughtCars()))
                .sorted((f, s) -> s.getPrice().compareTo(f.getPrice()))
                .collect(Collectors.toList());
    }

    private List<SalePriceDto> getSalePriceDtos(List<Sale> sales) {
        return sales.stream()
                .map(sale -> {
                    SalePriceDto salePriceDto = modelMapper.map(sale, SalePriceDto.class);
                    salePriceDto.setCar(sale.getCar());
                    salePriceDto.setParts(sale.getCar().getParts());
                    salePriceDto.setPrice(salePriceDto.getParts()
                            .stream().map(Part::getPrice)
                            .reduce(BigDecimal.ZERO, BigDecimal::add));
                    salePriceDto.setPriceWithDiscount(salePriceDto.getPrice().multiply(BigDecimal.valueOf(1).subtract(sale.getDiscount())));
                    return salePriceDto;
                }).collect(Collectors.toList());
    }

}