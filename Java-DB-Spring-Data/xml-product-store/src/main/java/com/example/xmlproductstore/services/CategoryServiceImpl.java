package com.example.xmlproductstore.services;

import com.example.xmlproductstore.dtos.CategoriesByProductsCountRootDto;
import com.example.xmlproductstore.dtos.CategoriesInfoDto;
import com.example.xmlproductstore.dtos.CategorySeedRootDto;
import com.example.xmlproductstore.entities.Category;
import com.example.xmlproductstore.entities.Product;
import com.example.xmlproductstore.repositories.CategoryRepository;
import com.example.xmlproductstore.utils.ValidatorUtilImpl;
import com.example.xmlproductstore.utils.XMLParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static com.example.xmlproductstore.constants.IOFilePaths.CATEGORIES_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ValidatorUtilImpl validatorUtil;
    private final XMLParser xmlParser;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ValidatorUtilImpl validatorUtil, XMLParser xmlParser, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.validatorUtil = validatorUtil;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws JAXBException, FileNotFoundException {

        if (categoryRepository.count() > 0) {
            return;
        }

        CategorySeedRootDto categorySeedRootDto = xmlParser.fromFIle(CATEGORIES_FILE_PATH, CategorySeedRootDto.class);

        categorySeedRootDto
                .getCategories()
                .stream()
                .filter(validatorUtil::isValid)
                .map(categorySeedDto ->
                        modelMapper.map(categorySeedDto,
                                Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public List<Category> getRandomCategories() {
        List<Category> categories = new ArrayList<>();
        long numberOfCategories = categoryRepository.count();
        for (int i = 0; i < numberOfCategories; i++) {
            long randomId = ThreadLocalRandom.current().nextInt(1, 3);
            categories.add(categoryRepository.getById(randomId));
        }
        return categories;
    }

    @Override
    public CategoriesByProductsCountRootDto getAllCategoriesInfo() {

        CategoriesByProductsCountRootDto countRootDto = new CategoriesByProductsCountRootDto();

        countRootDto.setCategories(

                categoryRepository
                        .findAllCatagories()
                        .stream()
                        .filter(validatorUtil::isValid)
                        .map(category -> {
                            CategoriesInfoDto categoriesInfoDto =
                                  new CategoriesInfoDto();

                            categoriesInfoDto.setName(category.getName());
                            categoriesInfoDto.setCount(category.getProducts().size());

                            categoriesInfoDto.setPrice(category
                                    .getProducts()
                                    .stream()
                                    .map(Product::getPrice)
                                    .reduce(BigDecimal.ZERO, BigDecimal::add)
                                    .divide(new BigDecimal(
                                                    category.getProducts().size()),
                                            RoundingMode.CEILING));

                            categoriesInfoDto.setTotalRevenue(category
                                    .getProducts()
                                    .stream()
                                    .map(Product::getPrice)
                                    .reduce(BigDecimal.ZERO, BigDecimal::add));

                            return categoriesInfoDto;
                        })
                        .collect(Collectors.toSet()));

        return countRootDto;
    }

    @Override
    public Category getRandomCategory() {

        long count = this.categoryRepository.count();
        long randomId = ThreadLocalRandom.current().nextLong(1, count + 1);
        return this.categoryRepository.getById(randomId);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryServiceImpl that = (CategoryServiceImpl) o;
        return Objects.equals(categoryRepository, that.categoryRepository) && Objects.equals(validatorUtil, that.validatorUtil) && Objects.equals(xmlParser, that.xmlParser) && Objects.equals(modelMapper, that.modelMapper);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryRepository, validatorUtil, xmlParser, modelMapper);
    }
}
