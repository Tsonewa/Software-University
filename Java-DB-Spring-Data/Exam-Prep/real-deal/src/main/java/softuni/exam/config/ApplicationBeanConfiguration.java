package softuni.exam.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.*;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import softuni.exam.models.Car;
import softuni.exam.models.dtos.CarsSeedDto;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.ValidationUtilImpl;

import java.time.LocalDate;
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

        modelmapper.addConverter(new Converter<String, LocalDate>() {
            @Override
            public LocalDate convert(MappingContext<String, LocalDate> mappingContext) {
                return LocalDate.
                        parse(mappingContext.getSource(),
                                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            }
        });


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

}
