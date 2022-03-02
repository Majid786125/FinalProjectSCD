package com.example.FinalProject.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "donate")
public class Donate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donate_id", nullable = false)
    private Integer id;

    @Column(name = "donate_amount", nullable = false)
    private String donateAmount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Convert(disableConversion = true)
    @Column(name = "donate_time", nullable = false)
    private LocalTime donateTime;

    @Convert(disableConversion = true)
    @Column(name = "donate_date", nullable = false)
    private LocalDate donateDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sign_up_id", nullable = false)
    private Signup signUp;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Signup getSignUp() {
        return signUp;
    }

    public void setSignUp(Signup signUp) {
        this.signUp = signUp;
    }

    public LocalDate getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(LocalDate donateDate) {
        this.donateDate = donateDate;
    }

    public LocalTime getDonateTime() {
        return donateTime;
    }

    public void setDonateTime(LocalTime donateTime) {
        this.donateTime = donateTime;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getDonateAmount() {
        return donateAmount;
    }

    public void setDonateAmount(String donateAmount) {
        this.donateAmount = donateAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}