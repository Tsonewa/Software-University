package com.example.sdmappingex.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean
    private static ModelMapper getMapper (){
    return new ModelMapper();
}
}
