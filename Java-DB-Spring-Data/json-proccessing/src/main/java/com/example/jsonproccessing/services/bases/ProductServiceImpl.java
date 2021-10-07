package com.example.jsonproccessing.services.bases;

import com.example.jsonproccessing.dtos.*;
import com.example.jsonproccessing.entities.Product;
import com.example.jsonproccessing.repos.ProductRepository;
import com.example.jsonproccessing.services.CategoryService;
import com.example.jsonproccessing.services.ProductService;
import com.example.jsonproccessing.services.UserService;
import com.example.jsonproccessing.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.jsonproccessing.constants.Const.PRODUCTS_SEED_FILE_PATH;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final UserService userService;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil, UserService userService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedProducts() throws IOException {

        if(productRepository.count() > 0){
            return;
        }

        String data = Files.readString(Path.of(PRODUCTS_SEED_FILE_PATH));

        Arrays.stream(gson.fromJson(data, ProductsSeedDto[].class))
                .filter(validationUtil::isValid)
                .map(p -> {
                    Product product = modelMapper.map(p, Product.class);
                    product.setSellerId(userService.findRandomUser());
                    if(product.getPrice().compareTo(BigDecimal.valueOf(900L)) > 0){
                        product.setBuyerId(userService.findRandomUser());
                    }

                    product.setCategories(categoryService.getRandomCategory());

                    return product;
                })
                .forEach(productRepository::save);

    }

    @Override
    public Set<ProductPriceBetweenDto> getProductsInRange(BigDecimal lower, BigDecimal higher) {

        return productRepository.findAllByPriceBetweenAndBuyerIdIsNullOrderByPrice(lower, higher)
                .stream()
                .map(product -> {
                   ProductPriceBetweenDto productPriceBetweenDto =
                           modelMapper.map(product, ProductPriceBetweenDto.class);

                    productPriceBetweenDto.setSeller(String.format("%s %s",
                           product.getSellerId().getFirstName(),
                           product.getSellerId().getLastName()));

                   return productPriceBetweenDto;
                })
                .collect(Collectors.toSet());

    }

    @Override
    public String getSellersAndTheirProducts() {

        UsersProductsDto usersCount = new UsersProductsDto();

        Map<Long, UsersProductsUsersDto> sellerSoldProducts = new LinkedHashMap<>();
        Map<Long, List<UsersProductsProductsSoldDto>> soldProducts = new LinkedHashMap<>();

        this.productRepository.findAllByBuyerIdIsNotNull()
                .forEach(product -> {
                    UsersProductsUsersDto soldProductsDto = modelMapper.map(product, UsersProductsUsersDto.class);
                    UsersProductsProductsSoldDto soldProductDataDto = modelMapper.map(product, UsersProductsProductsSoldDto.class);
                    sellerSoldProducts.putIfAbsent(product.getSellerId().getId(), soldProductsDto);
                    soldProducts.putIfAbsent(product.getSellerId().getId(), new ArrayList<>());
                    soldProducts.get(product.getSellerId().getId()).add(soldProductDataDto);
                });


        for (Map.Entry<Long, List<UsersProductsProductsSoldDto>> entrySet : soldProducts.entrySet()) {
            UsersProductsProductsSoldDto soldProductData = new UsersProductsProductsSoldDto();
            soldProductData.setCount(entrySet.getValue().size());
            soldProductData.setProducts(entrySet.getValue());
            sellerSoldProducts.get(entrySet.getKey()).setSoldProducts(soldProductData);
        }
        usersCount.setUsersCount(sellerSoldProducts.size());
        usersCount.setUsers(new ArrayList<>(sellerSoldProducts.values()));
        usersCount.getUsers().sort((a,b)->Integer.compare(b.getSoldProducts().getCount(),a.getSoldProducts().getCount()));
        return this.gson.toJson(usersCount);
    }
    }
