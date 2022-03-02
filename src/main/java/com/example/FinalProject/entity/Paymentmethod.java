package com.example.FinalProject.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "paymentmethod")
public class Paymentmethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false)
    private Integer id;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Convert(disableConversion = true)
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Convert(disableConversion = true)
    @Column(name = "payment_time")
    private LocalTime paymentTime;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sign_up_id", nullable = false)
    private Signup signUp;

    @Column(name = "user_name", nullable = false)
    private String userName;

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

    public LocalTime getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(LocalTime paymentTime) {
        this.paymentTime = paymentTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}