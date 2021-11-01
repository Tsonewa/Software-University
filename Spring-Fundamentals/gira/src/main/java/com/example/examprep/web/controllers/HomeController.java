package com.example.examprep.web.controllers;

import com.example.examprep.models.enitites.view.TaskViewModel;
import com.example.examprep.services.TaskService;
import com.example.examprep.services.UserService;
import com.example.examprep.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final TaskService taskService;
    private final UserService userService;


    public HomeController(CurrentUser currentUser, TaskService taskService, UserService userService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model){

        if(currentUser.getId() == null){
            return "index";
        }

        List<TaskViewModel> allTasks = taskService.findAllTasks();
        model.addAttribute("tasks", allTasks);

        return "home";

    }
}
