package com.kharidlo.service.authentication.controller;

import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;
import com.kharidlo.service.authentication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<AuthenticationToken> login(@RequestBody AuthenticationCredentials credentials) {
        Optional<AuthenticationToken > token = loginService.login(credentials);

        if(token.isPresent())
            return new ResponseEntity(token.get(), HttpStatus.ACCEPTED);
        else
            return new ResponseEntity("{\"message\":\"Invalid Credentials\"}",HttpStatus.FORBIDDEN);
    }
}
