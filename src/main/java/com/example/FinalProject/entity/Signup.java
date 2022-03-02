package com.example.FinalProject.entity;

import javax.persistence.*;

@Entity
@Table(name = "signup")
public class Signup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sign_up_id", nullable = false)
    private Integer id;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone_no", nullable = false)
    private String phoneNo;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne(optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @ManyToOne(optional = false)
    @JoinColumn(name = "religion_id", nullable = false)
    private Religion religion;

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}