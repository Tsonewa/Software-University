package com.example.xmlproductstore.services;

import com.example.xmlproductstore.dtos.ProductInRangeRootDto;
import com.example.xmlproductstore.dtos.ProductsInRangeDto;
import com.example.xmlproductstore.dtos.ProductsSeedRootDto;
import com.example.xmlproductstore.entities.Product;
import com.example.xmlproductstore.repositories.ProductRepository;
import com.example.xmlproductstore.utils.ValidatorUtil;
import com.example.xmlproductstore.utils.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.xmlproductstore.constants.IOFilePaths.OUTPUT_FILES_PATH;
import static com.example.xmlproductstore.constants.IOFilePaths.PRODUCTS_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ValidatorUtil validatorUtil;
    private final XMLParser xmlParser;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ValidatorUtil validatorUtil, XMLParser xmlParser, UserService userService, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts() throws JAXBException, FileNotFoundException {

        if(productRepository.count() > 0){
            return;
        }

        ProductsSeedRootDto productsSeedRootDto = xmlParser.fromFIle(PRODUCTS_FILE_PATH, ProductsSeedRootDto.class);

       productsSeedRootDto
                .getProducts()
                .stream()
                .filter(validatorUtil::isValid)
                .map(productsSeedDto -> {
                    Product product = new Product();

                    product.setSeller(userService.getRandomSeller());
                    product.setBuyer(userService.getRandomBuyer());
                    product.setCategories(categoryService.getRandomCategories());

                    modelMapper.map(productsSeedDto, product);
                    return product;
                })
               .map(product -> modelMapper.map(product, Product.class))
               .forEach(productRepository::save);

    }

    @Override
    public ProductInRangeRootDto getAllProductsWhitPRiceInRange(BigDecimal lower, BigDecimal higher) {
        ProductInRangeRootDto collection = new ProductInRangeRootDto();

        collection.setProducts(
                productRepository.findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lower
                        , higher)
                        .stream()
                        .filter(validatorUtil::isValid)
                        .map(product -> {
                            ProductsInRangeDto productsInRangeDto = modelMapper
                                    .map(product, ProductsInRangeDto.class);

                            productsInRangeDto.setSeller(String.format("%s %s",
                                    product.getSeller().getFirstName(),
                                    product.getSeller().getLastName()));

                            return productsInRangeDto;
                        })
                        .collect(Collectors.toSet())
        );

             return collection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductServiceImpl that = (ProductServiceImpl) o;
        return Objects.equals(productRepository, that.productRepository) && Objects.equals(validatorUtil, that.validatorUtil) && Objects.equals(xmlParser, that.xmlParser) && Objects.equals(userService, that.userService) && Objects.equals(modelMapper, that.modelMapper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepository, validatorUtil, xmlParser, userService, modelMapper);
    }
}
