package com.example.exam.services;

import com.example.exam.models.enitites.Artist;
import com.example.exam.models.enitites.enums.ArtistNameEnum;

public interface ArtistService {
    void initArtists();

    Artist findArtistByName(ArtistNameEnum name);
}


