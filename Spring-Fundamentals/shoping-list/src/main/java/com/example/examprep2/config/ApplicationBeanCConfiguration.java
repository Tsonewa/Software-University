package com.example.examprep2.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationBeanCConfiguration {

    @Bean
    public ModelMapper modelMapper(){
    return new ModelMapper();
}
}
