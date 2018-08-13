package io.gdiazs.tasklist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import io.gdiazs.tasklist.services.TaskService;

/**
 * TaskController
 */
@Controller("/task")
public class TaskController {

    @Autowired
    @Qualifier(value = "taskServiceFile")
    private TaskService taskService;

    @GetMapping
    public String showTaks(){

        return "task/index";
    }

}