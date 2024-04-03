package com.Petadaptation.adaptation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Petadaptation.adaptation.model.Login;
import com.Petadaptation.adaptation.repository.LoginRepo;

@Service
public class LoginService {
    @Autowired
    private LoginRepo loginRepo;

    public Login createLogin(Login login){
        return loginRepo.save(login);
    }

    public List<Login> getAllLogins(){
        return loginRepo.findAll();
    }

    public Optional<Login> getLoginById(Integer loginId){
        return loginRepo.findById(loginId);
    }
    
    
}
