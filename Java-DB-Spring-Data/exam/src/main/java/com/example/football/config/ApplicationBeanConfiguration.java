package com.example.football.config;

import com.example.football.util.ValidationUtil;
import com.example.football.util.ValidationUtilImpl;
import com.example.football.util.XMLParser;
import com.example.football.util.XMLParserImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public Gson gson() {

        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    @Bean
    public ValidationUtil validationUtil() {

        return new ValidationUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelmapper = new ModelMapper();

        modelmapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.
                        parse(mappingContext.getSource(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });

        return modelmapper;
    }

    @Bean
    public XMLParser xmlParser(){
        return new XMLParserImpl();
    }


}
