package com.example.examprep2.models.entities;


import com.example.examprep2.models.BaseEntity;
import com.example.examprep2.models.enums.CategoryEnum;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @Column(unique = true)
    private CategoryEnum name;
    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }


    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
