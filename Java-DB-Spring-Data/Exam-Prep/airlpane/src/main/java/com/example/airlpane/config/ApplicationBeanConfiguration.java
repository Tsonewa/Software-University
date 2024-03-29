package com.example.airlpane.config;

import com.example.airlpane.util.ValidationUtil;
import com.example.airlpane.util.ValidationUtilImpl;
import com.example.airlpane.util.XmlParser;
import com.example.airlpane.util.XmlParserImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
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

        modelmapper.addConverter(new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(MappingContext<String, LocalDateTime> mappingContext) {
                return LocalDateTime.
                        parse(mappingContext.getSource(),
                                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        });


        return modelmapper;
    }

    @Bean
    public XmlParser xmlParser(){


        return new XmlParserImpl();
    }

}
