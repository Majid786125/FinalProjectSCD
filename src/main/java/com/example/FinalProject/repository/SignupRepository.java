package com.example.FinalProject.repository;

import com.example.FinalProject.entity.Signup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SignupRepository extends JpaRepository<Signup, Integer> {
    Optional<Signup> findAllById(long id);
}