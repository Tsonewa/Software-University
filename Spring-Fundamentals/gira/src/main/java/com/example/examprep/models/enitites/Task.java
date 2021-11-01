package com.example.examprep.models.enitites;

import com.example.examprep.models.enitites.enums.ProgressEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
public class Task extends BaseEntity{

    @Column(unique = true)
    @NotBlank
    private String name;
    @Column(columnDefinition = "TEXT")
    @NotBlank
    private String description;
    @Enumerated(value = EnumType.STRING)
    @NotNull
    private ProgressEnum progress;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @PastOrPresent
    @NotNull
    @Column(name = "due_date")
    private LocalDate dueDate;
    @ManyToOne(optional = false)
    private Classification classification;
    @ManyToOne(optional = false)
    private User user;

    public Task() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressEnum progress) {
        this.progress = progress;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
