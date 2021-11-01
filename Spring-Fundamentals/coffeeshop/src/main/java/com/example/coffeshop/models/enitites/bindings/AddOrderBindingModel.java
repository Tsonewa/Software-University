package com.example.coffeshop.models.enitites.bindings;

import com.example.coffeshop.models.enitites.Category;
import com.example.coffeshop.models.enitites.User;
import com.example.coffeshop.models.enitites.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddOrderBindingModel {

    @NotBlank
    @Size(min = 3,max = 20)
    private String name;
    @Positive
    @NotNull
    private BigDecimal price;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @PastOrPresent
    @NotNull
    private LocalDateTime time;
    @NotNull
    private CategoryEnum category; //CAKE
    @NotBlank
    @Size(min = 5)
    private String description;

    public AddOrderBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
