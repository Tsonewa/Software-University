package com.example.xmlproductstore.configurations;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.BufferedReader;
import java.io.InputStreamReader;


@Configuration
public class DataSourceConfig {

    public DataSourceConfig() { }

    @Bean
    public BufferedReader bufferedReader(){
    return new BufferedReader(new InputStreamReader(System.in));
}

    @Bean
    public StringBuilder sb(){
        return new StringBuilder();
    }

    @Bean
    public ModelMapper modelMapper() {

        ModelMapper modelMapper = new ModelMapper();

//        modelMapper.typeMap(GameCreationDto.class, Game.class)
//                .addMappings(mapper -> mapper.map(GameCreationDto::getThubnailURL,
//                        Game::setImageThumbnail));
//
//        Converter<String, LocalDate> localDateConverter = new Converter<String, LocalDate>() {
//            @Override
//            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
//                return LocalDate.parse(mappingContext.getSource(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
//            }
//        };

//        modelMapper.addConverter(localDateConverter);

//        mapper.addMappings(new PropertyMap<FirstLastNameSource, FullNameTarget>() {
//            @Override
//            protected void configure() {
//                using(
//                        new Converter<FirstLastNameSource, String>() {
//                            @Override
//                            public String convert(MappingContext<FirstLastNameSource, String> context) {
//                                return context.getSource().getFirstName() + " " + context.getSource().getLastName();
//                            }
//                        }
//                ).map(source, destination.getFullName());
//            }
//        });

        return modelMapper;
        }
//
//        @Bean
//    public Gson gsonBuilder(){
//
//        return new GsonBuilder()
//                .setPrettyPrinting()
//                .excludeFieldsWithoutExposeAnnotation()
//                .create();
//        }


}
