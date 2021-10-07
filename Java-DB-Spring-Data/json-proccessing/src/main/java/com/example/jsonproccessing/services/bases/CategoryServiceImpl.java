package com.example.jsonproccessing.services.bases;

import com.example.jsonproccessing.dtos.CategorySeedDto;
import com.example.jsonproccessing.dtos.CaterogiesInfoDto;
import com.example.jsonproccessing.entities.Categories;
import com.example.jsonproccessing.repos.CategoryRepository;
import com.example.jsonproccessing.services.CategoryService;
import com.example.jsonproccessing.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.jsonproccessing.constants.Const.CATEGORIES_SEED_FILE_PATH;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, Gson gson, ModelMapper modelMapper,ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void seedCategories() throws IOException {

        if (categoryRepository.count() > 0){
            return;
        }

        String fileContent = Files.readString(Path.of(CATEGORIES_SEED_FILE_PATH));

        Arrays.stream(gson.fromJson(fileContent, CategorySeedDto[].class))
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Categories.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Categories> getRandomCategory() {

        Set<Categories> categories = new HashSet<>();
        int count = ThreadLocalRandom.current().nextInt(1,3);
        long totalCount = categoryRepository.count();

        for (int i = 0; i < count; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, totalCount + 1);

            categories.add(categoryRepository.getById(randomId));
        }

        return categories.isEmpty() ? null : categories;
    }

    @Override
    public List<CaterogiesInfoDto> getCategoriesByProductsCount() {

        List<Object[]> categoriesCount = categoryRepository.findAllCatagories();

        List<CaterogiesInfoDto> categoriesInfo = new ArrayList<>();
        for (Object[] obj : categoriesCount) {
            String category = (String) obj[0];
            long count = (Long) obj[1];
            BigDecimal avgPrice =new BigDecimal(obj[2].toString());
            BigDecimal totalPrice =new BigDecimal(obj[3].toString());

            CaterogiesInfoDto categoryByProductCountDto = new CaterogiesInfoDto(category,(int)count,avgPrice,totalPrice);
            categoriesInfo.add(categoryByProductCountDto);
        }
        return categoriesInfo;
    }
}
