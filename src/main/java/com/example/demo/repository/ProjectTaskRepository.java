package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ProjectTask;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer> {

    // Generates: SELECT * FROM project_task WHERE developer_name = ?
    List<ProjectTask> findByDeveloperName(String developerName);

    // Generates: SELECT * FROM project_task WHERE status = ?
    List<ProjectTask> findByStatus(String status);

    // Generates: SELECT * FROM project_task WHERE LOWER(task_name) LIKE LOWER('%keyword%')
    List<ProjectTask> findByTaskNameContainingIgnoreCase(String keyword);
}