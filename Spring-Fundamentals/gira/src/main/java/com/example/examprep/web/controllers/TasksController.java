package com.example.examprep.web.controllers;

import com.example.examprep.models.enitites.bindings.TaskAddBindingModel;
import com.example.examprep.models.enitites.service.TaskAddServiceModel;
import com.example.examprep.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TasksController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;


    public TasksController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String addOrder(){

        return "add-task";
    }

    @ModelAttribute
    public TaskAddBindingModel taskAddBindingModel(){
        return new TaskAddBindingModel();
    }

    @PostMapping("/add")
    public String addOrder(@Valid TaskAddBindingModel taskAddBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){

        if(bindingResult.hasErrors()){

            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);

            return "redirect:add";
        }

        TaskAddServiceModel task =
                modelMapper.map(taskAddBindingModel, TaskAddServiceModel.class);

        taskService.addTast(task);

        return "home";

    }

    @GetMapping("/ready/{id}")
    public String readey(@PathVariable Long id){

        taskService.readyTask(id);

        return "redirect:/";
    }
}
