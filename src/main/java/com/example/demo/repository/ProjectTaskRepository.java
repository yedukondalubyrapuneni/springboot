package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ProjectTask;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer> {

   
    List<ProjectTask> findByDeveloperName(String developerName);


    List<ProjectTask> findByStatus(String status);

    List<ProjectTask> findByTaskNameContainingIgnoreCase(String keyword);
}