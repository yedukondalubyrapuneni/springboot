package com.example.demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.model.ProjectTask;
import com.example.demo.repository.ProjectTaskRepository;

@Service
public class TaskService {

    private final Developer developer;
    private final ProjectTaskRepository taskRepository;

    public TaskService(Developer developer, ProjectTaskRepository taskRepository) {
        this.developer = developer;
        this.taskRepository = taskRepository;
    }

    public List<ProjectTask> getAllTasks() {
        return taskRepository.findAll();
    }

    public ProjectTask getTaskById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public ProjectTask createTask(ProjectTask newTask) {
        if (newTask.getStatus() == null || newTask.getStatus().isBlank()) {
            newTask.setStatus(developer.build());
        }
        return taskRepository.save(newTask);
    }

    public ProjectTask updateTask(Integer id, ProjectTask updatedTask) {
        return taskRepository.findById(id).map(existing -> {
            existing.setDeveloperName(updatedTask.getDeveloperName());
            existing.setTaskName(updatedTask.getTaskName());
            existing.setStatus(updatedTask.getStatus());
            return taskRepository.save(existing);
        }).orElse(null);
    }

    public boolean deleteTask(Integer id) {
        if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id);
            return true;
        }
        return false;
    }
}