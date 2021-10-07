package com.example.hiberspring.service.impl;

import com.example.hiberspring.repository.ProductRepository;
import com.example.hiberspring.service.ProductService;
import com.example.hiberspring.util.FileUtil;
import com.example.hiberspring.util.ValidationUtil;
import com.example.hiberspring.util.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final FileUtil fileUtil;
    private final ProductRepository productRepository;
    private final XMLParser xmlParser;

    public ProductServiceImpl(ModelMapper modelMapper, ValidationUtil validationUtil, FileUtil fileUtil, ProductRepository productRepository, XMLParser xmlParser) {
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.fileUtil = fileUtil;
        this.productRepository = productRepository;
        this.xmlParser = xmlParser;
    }

    @Override
    public Boolean productsAreImported() {

        return productRepository.count() < 0;
    }

    @Override
    public String readProductsXmlFile() throws IOException {
        return null;
    }

    @Override
    public String importProducts() throws JAXBException {
        return null;
    }
}
