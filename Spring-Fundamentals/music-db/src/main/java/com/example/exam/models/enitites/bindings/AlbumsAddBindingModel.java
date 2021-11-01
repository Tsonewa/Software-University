package com.example.exam.models.enitites.bindings;

import com.example.exam.models.enitites.enums.ArtistNameEnum;
import com.example.exam.models.enitites.enums.GenreEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumsAddBindingModel {

    @Size(min = 3, max = 20)
    @NotBlank
    private String name;
    @Size(min = 5)
    @NotBlank
    private String imageUrl;
    @NotNull
    @Positive
    private BigDecimal price;
    @Min(10)
    @NotNull
    private Integer copies;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private LocalDate releaseDate;
    @NotBlank
    private String producerName;
    @NotNull
    private ArtistNameEnum artist;
    @NotNull
    private GenreEnum genre;
    @NotBlank
    @Size(min = 5)
    private String description;

    public AlbumsAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getCopies() {
        return copies;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProducerName() {
        return producerName;
    }

    public void setProducerName(String producerName) {
        this.producerName = producerName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
