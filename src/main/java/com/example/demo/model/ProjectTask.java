package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProjectTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String developerName;
    private String taskName;
    private String status;

    // Many Tasks -> One DeveloperProfile (creates developer_id Foreign Key in MySQL)
    @ManyToOne
    @JoinColumn(name = "developer_id")
    private DeveloperProfile developerProfile;

    public ProjectTask() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getDeveloperName() { return developerName; }
    public void setDeveloperName(String developerName) { this.developerName = developerName; }

    public String getTaskName() { return taskName; }
    public void setTaskName(String taskName) { this.taskName = taskName; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public DeveloperProfile getDeveloperProfile() { return developerProfile; }
    public void setDeveloperProfile(DeveloperProfile developerProfile) { this.developerProfile = developerProfile; }
}