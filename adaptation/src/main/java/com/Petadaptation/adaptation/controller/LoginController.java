package com.Petadaptation.adaptation.controller;

import org.springframework.web.bind.annotation.RestController;

import com.Petadaptation.adaptation.service.LoginService;

import com.Petadaptation.adaptation.model.Login;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/Petadaptation/adaptation")
public class LoginController {

    @Autowired
    private LoginService loginService;
    
    @PostMapping("/login")
    public ResponseEntity<Login> createUser(@RequestBody Login login){
        Login createdLogin = loginService.createLogin(login);
        if (createdLogin != null) {
            return new ResponseEntity<>(createdLogin, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<List<Login>> getAllLogins(){
        List<Login> logins = loginService.getAllLogins();
        if (!logins.isEmpty()) {
            return new ResponseEntity<>(logins, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/login/{loginId}")
    public ResponseEntity<Login> getLoginById(@PathVariable int loginId){
        Optional<Login> login = loginService.getLoginById(loginId);
        if (login.isPresent()) {
            return new ResponseEntity<>(login.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
