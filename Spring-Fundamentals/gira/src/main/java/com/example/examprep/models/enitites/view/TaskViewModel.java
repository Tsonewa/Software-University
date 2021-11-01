package com.example.examprep.models.enitites.view;

import com.example.examprep.models.enitites.User;
import com.example.examprep.models.enitites.enums.ClassificationNameEnum;
import com.example.examprep.models.enitites.enums.ProgressEnum;

import java.time.LocalDate;

public class TaskViewModel {

    private Long id;
    private String name;
    private User assignTo;
    private ClassificationNameEnum classificationName;
    private LocalDate dueDate;
    private ProgressEnum progress;


    public TaskViewModel() {
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

    public User getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(User assignTo) {
        this.assignTo = assignTo;
    }

    public ClassificationNameEnum getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(ClassificationNameEnum classificationName) {
        this.classificationName = classificationName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public ProgressEnum getProgress() {
        return progress;
    }

    public void setProgress(ProgressEnum progress) {
        this.progress = progress;
    }
}
