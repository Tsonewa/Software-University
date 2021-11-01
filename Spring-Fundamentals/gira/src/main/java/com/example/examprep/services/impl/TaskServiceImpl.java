package com.example.examprep.services.impl;

import com.example.examprep.models.enitites.Classification;
import com.example.examprep.models.enitites.Task;
import com.example.examprep.models.enitites.enums.ProgressEnum;
import com.example.examprep.models.enitites.service.TaskAddServiceModel;
import com.example.examprep.models.enitites.view.TaskViewModel;
import com.example.examprep.reps.TaskRepository;
import com.example.examprep.services.ClassificationService;
import com.example.examprep.services.TaskService;
import com.example.examprep.services.UserService;
import com.example.examprep.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;
    private final UserService userService;
private final TaskRepository taskRepository;
private ClassificationService classificationService;

    public TaskServiceImpl(ModelMapper modelMapper, CurrentUser currentUser, UserService userService,  TaskRepository taskRepository, ClassificationService classificationService) {
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
        this.userService = userService;
        this.taskRepository = taskRepository;
        this.classificationService = classificationService;
    }


    @Override
    public void addTast(TaskAddServiceModel task) {

        Task currTask = modelMapper.map(task, Task.class);
        currTask.setProgress(ProgressEnum.OPEN);
        currTask.setUser(userService.findUserById(currentUser.getId()));
        Classification cl = classificationService.findClassificationByName(task.getClassificationName());
        currTask.setClassification(cl);

        taskRepository.save(currTask);
    }

    @Override
    public List<TaskViewModel> findAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(o -> {
                    TaskViewModel currTask = modelMapper.map(o, TaskViewModel.class);
                    currTask.setAssignTo(o.getUser());

                    return currTask;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void readyTask(Long id) {

        taskRepository.deleteById(id);
    }
}
