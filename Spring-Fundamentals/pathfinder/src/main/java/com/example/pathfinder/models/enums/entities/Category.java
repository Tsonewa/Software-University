package com.example.pathfinder.models.enums.entities;

import com.example.pathfinder.models.enums.CategoryEnum;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;
    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @ManyToMany
    private Set<Route> routes;

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
