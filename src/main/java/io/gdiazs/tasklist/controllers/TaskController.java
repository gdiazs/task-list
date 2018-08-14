package io.gdiazs.tasklist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.gdiazs.tasklist.models.TaskModel;
import io.gdiazs.tasklist.services.TaskService;

/**
 * TaskController
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    @Qualifier(value = "taskServiceFile")
    private TaskService taskService;

    @GetMapping
    public String showTasks(Model model){
        model.addAttribute("tasks", this.taskService.findAllTasks());
        return "task/index";
    }

    @GetMapping("/new")
    public String showTaskForm(Model model){
        model.addAttribute("task", new TaskModel());
        return "task/new";
    }

    @PostMapping("/add")
    public String addTask(TaskModel taskModel){

        this.taskService.insertTask(taskModel);

        return "redirect:/task";

    }


    
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable String id){
        this.taskService.deleteTask(id);
        return "redirect:/task";
    }

}