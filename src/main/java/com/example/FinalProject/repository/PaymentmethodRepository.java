package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Paymentmethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentmethodRepository extends JpaRepository<Paymentmethod, Integer>, JpaSpecificationExecutor<Paymentmethod> {
}