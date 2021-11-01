package com.example.exam.init;

import com.example.exam.services.ArtistService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

      //TODO inject service
    private final ArtistService artistService;

    public DataInitializer(ArtistService artistService) {

        this.artistService = artistService;
    }

    @Override
    public void run(String... args) throws Exception {

    //TODO initialize data

        artistService.initArtists();

    }
}
