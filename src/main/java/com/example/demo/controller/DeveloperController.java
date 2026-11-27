package com.example.demo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.ProjectTask;
import com.example.demo.service.Developer;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DeveloperController {

    private final Developer developer;
    private final TaskService taskService;

    public DeveloperController(Developer developer, TaskService taskService) {
        this.developer = developer;
        this.taskService = taskService;
    }

    @GetMapping("/build")
    public String startBuild() {
        return developer.build();
    }

    @GetMapping("/tasks")
    public List<ProjectTask> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public ProjectTask getTaskById(@PathVariable Integer id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/tasks")
    public ProjectTask createTask(@RequestBody ProjectTask newTask) {
        return taskService.createTask(newTask);
    }

    @PutMapping("/tasks/{id}")
    public ProjectTask updateTask(@PathVariable Integer id, @RequestBody ProjectTask updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable Integer id) {
        return taskService.deleteTask(id)
                ? "Task ID " + id + " deleted successfully!"
                : "Task ID " + id + " not found.";
    }
    @GetMapping("/tasks/search")
    public List<ProjectTask> searchTasks(@org.springframework.web.bind.annotation.RequestParam String keyword) {
        return taskService.searchTasksByKeyword(keyword);
    }

    
    @GetMapping("/tasks/status")
    public List<ProjectTask> filterByStatus(@org.springframework.web.bind.annotation.RequestParam String value) {
        return taskService.getTasksByStatus(value);
    }
}