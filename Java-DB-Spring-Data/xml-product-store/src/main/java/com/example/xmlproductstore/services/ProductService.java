package com.example.xmlproductstore.services;

import com.example.xmlproductstore.dtos.ProductInRangeRootDto;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;

public interface ProductService {

    void seedProducts() throws JAXBException, FileNotFoundException;

   ProductInRangeRootDto getAllProductsWhitPRiceInRange(BigDecimal lower, BigDecimal higher);
}
