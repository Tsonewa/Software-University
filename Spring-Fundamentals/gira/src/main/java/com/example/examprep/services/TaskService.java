package com.example.examprep.services;

import com.example.examprep.models.enitites.service.TaskAddServiceModel;
import com.example.examprep.models.enitites.view.TaskViewModel;

import java.util.List;

public interface TaskService {
    void addTast(TaskAddServiceModel task);

    List<TaskViewModel> findAllTasks();

    void readyTask(Long id);
}


