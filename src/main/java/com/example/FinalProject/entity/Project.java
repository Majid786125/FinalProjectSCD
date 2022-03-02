package com.example.FinalProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)
    private Integer id;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "project_img", nullable = false)
    private byte[] projectImg;

    @Column(name = "project_description", nullable = false, length = 1000)
    private String projectDescription;

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public byte[] getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(byte[] projectImg) {
        this.projectImg = projectImg;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}