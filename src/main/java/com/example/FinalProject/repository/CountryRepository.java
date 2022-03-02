package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}