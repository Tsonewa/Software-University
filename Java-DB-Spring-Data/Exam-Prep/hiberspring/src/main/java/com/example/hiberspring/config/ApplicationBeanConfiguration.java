package com.example.hiberspring.config;

import com.example.hiberspring.domain.dtos.BranchesNameAndTownDto;
import com.example.hiberspring.util.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.aspectj.weaver.ast.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public FileUtil fileUtil() {

        return new FileUtilImpl();
    }

    @Bean
    public Gson gson() {
        return new GsonBuilder().
                excludeFieldsWithoutExposeAnnotation().
                setPrettyPrinting().
                create();
    }

    @Bean
    public XMLParser xmlParser() {

        return new XMLParserImpl();
    }

    @Bean
    public ValidationUtil validationUtil() {

        return new ValidationUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return new ModelMapper();
    }
}
