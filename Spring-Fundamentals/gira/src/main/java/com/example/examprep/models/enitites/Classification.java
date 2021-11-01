package com.example.examprep.models.enitites;

import com.example.examprep.models.enitites.enums.ClassificationNameEnum;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "classifications")
public class Classification extends BaseEntity{

    @NotNull
    @Enumerated(value = EnumType.STRING)
    @Column(name = "classification_name")
    private ClassificationNameEnum classificationName;
    @Column(columnDefinition = "TEXT")
    @NotBlank
    private String description;

    public Classification() {
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
