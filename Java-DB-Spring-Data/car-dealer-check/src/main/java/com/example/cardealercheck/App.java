package com.example.cardealercheck;

import com.example.cardealercheck.constants.GlobalApplicationConstants;
import com.example.cardealercheck.service.*;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;

@Controller
public class App implements CommandLineRunner {

private final CarService carService;
private final SupplierService supplierService;
private final PartService partService;
private final CustomerService customerService;
private final SaleService saleService;
private final Gson gson;

    public App(CarService carService, SupplierService supplierService, PartService partService, CustomerService customerService, SaleService saleService, Gson gson) {
        this.carService = carService;
        this.supplierService = supplierService;
        this.partService = partService;
        this.customerService = customerService;
        this.saleService = saleService;
        this.gson = gson;
    }

    @Override
    public void run(String... args) throws Exception {

//        supplierService.seedData();
//        partService.seedData();
//        carService.seedData();
//        customerService.seedData();
//        saleService.seedData();

//        writeToFile(GlobalApplicationConstants.FILE_PATH_OUT + "ordered-customers.json",
//                gson.toJson(customerService.getOrderedCustomers()));

//        writeToFile(GlobalApplicationConstants.FILE_PATH_OUT + "toyota-cars.json",
//                gson.toJson(carService.getCarsFromMakeToyota("Toyota")));

//        writeToFile(GlobalApplicationConstants.FILE_PATH_OUT + "locale-supplies.json",
//                gson.toJson(supplierService.getLocalSuppliers()));

//        writeToFile(GlobalApplicationConstants.FILE_PATH_OUT + "cars-parts.json",
//                gson.toJson(carService.getCarsAndParts()));

//        writeToFile(GlobalApplicationConstants.FILE_PATH_OUT + "customers-total-sales.json",
//                gson.toJson(customerService.getCustomersWithTheirSales()));

//        writeToFile(GlobalApplicationConstants.FILE_PATH_OUT + "sales-discount.json",
//                gson.toJson(saleService.getAllSalesWithDiscount()));
    }

    private void writeToFile(String outputFilesPath, String data) throws IOException, IOException {

        Files.write(Path.of(outputFilesPath), Collections.singleton(data));
    }
}
