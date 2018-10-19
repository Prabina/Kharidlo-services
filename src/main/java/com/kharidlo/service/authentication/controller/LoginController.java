package com.kharidlo.service.authentication.controller;

import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public void login(AuthenticationCredentials credentials){
        loginService.login(credentials);
    }
}
