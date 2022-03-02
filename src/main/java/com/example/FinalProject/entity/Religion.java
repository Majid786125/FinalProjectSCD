package com.example.FinalProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "religion")
public class Religion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "religion_id", nullable = false)
    private Integer id;

    @Column(name = "religion_name", nullable = false)
    private String religionName;

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}