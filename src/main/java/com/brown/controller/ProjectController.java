package com.brown.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.brown.model.Task;
import com.brown.service.ProjectService;
import com.brown.service.TaskService;

@Controller
public class ProjectController {
    
    @Autowired
    ProjectService projectService;
    
    @Autowired
    TaskService taskService;
    
    /**
     * Shows the main project page
     * @return project.html
     */
    @GetMapping("/project") // => /teams/id/project
    public String showProject () {
        return "project";
    }
    
    /**
     * Updates the main project page after changes from the frontend
     * @param task
     * @param user
     * @param model
     * @return project.html
     */
    @PostMapping("/project")
    public String joinTeam (@ModelAttribute("task") Task task, Model model) {
        Task newTask = new Task();
        newTask.setName(task.getName());
        taskService.addTask(newTask);
        model.addAttribute("todoTasks", taskService.getAllTasks());
        return "project";
    }

}
