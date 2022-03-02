package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Religion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReligionRepository extends JpaRepository<Religion, Integer> {
}