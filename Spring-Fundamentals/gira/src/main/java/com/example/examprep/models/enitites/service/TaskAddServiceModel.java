package com.example.examprep.models.enitites.service;

import com.example.examprep.models.enitites.enums.ClassificationNameEnum;

import java.time.LocalDate;

public class TaskAddServiceModel {

    private Long id;
    private String name;
    private LocalDate dueDate;
    private ClassificationNameEnum classificationName;
    private String description;

    public TaskAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
