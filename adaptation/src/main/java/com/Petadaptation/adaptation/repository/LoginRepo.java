package com.Petadaptation.adaptation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Petadaptation.adaptation.model.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {    
}
