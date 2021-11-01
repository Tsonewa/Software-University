package com.example.examprep.models.enitites.bindings;

import com.example.examprep.models.enitites.enums.ClassificationNameEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class TaskAddBindingModel {

    @NotBlank
    @Size(min = 3,max = 20)
    private String name;
    @NotBlank
    @Size(min = 5)
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    @NotNull
    private LocalDate dueDate;
    @NotNull
    private ClassificationNameEnum classificationName;


    public TaskAddBindingModel() {
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
