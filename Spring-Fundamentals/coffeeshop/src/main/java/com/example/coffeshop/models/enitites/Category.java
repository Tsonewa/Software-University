package com.example.coffeshop.models.enitites;

import com.example.coffeshop.models.enitites.enums.CategoryEnum;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @NotBlank
    private String name;
    @Column(name = "needed_time")
    @NonNull
    @Positive
    private Integer neededTime;

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public Integer getTime() {
        return neededTime;
    }

    public void setTime(@NonNull Integer neededTime) {
        this.neededTime = neededTime;
    }
}
