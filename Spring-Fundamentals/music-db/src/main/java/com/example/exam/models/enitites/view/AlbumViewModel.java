package com.example.exam.models.enitites.view;

import com.example.exam.models.enitites.enums.ArtistNameEnum;
import com.example.exam.models.enitites.enums.GenreEnum;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumViewModel {

    private Long id;
    private String imageUrl;
    private String name;
    private ArtistNameEnum artist;
    private GenreEnum genre;
    private BigDecimal price;
    private LocalDate releaseDate;
    private Integer copies;

    public AlbumViewModel() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArtistNameEnum getArtist() {
        return artist;
    }

    public void setArtist(ArtistNameEnum artist) {
        this.artist = artist;
    }

    public GenreEnum getGenre() {
        return genre;
    }

    public void setGenre(GenreEnum genre) {
        this.genre = genre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
