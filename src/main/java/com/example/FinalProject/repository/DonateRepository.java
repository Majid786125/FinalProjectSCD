package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Donate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonateRepository extends JpaRepository<Donate, Integer> {
}