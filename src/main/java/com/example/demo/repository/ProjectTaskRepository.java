package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ProjectTask;

@Repository
public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Integer> {
}