package com.kharidlo.service.userRegistration.controller;

import com.kharidlo.service.userRegistration.service.IUserRegistrationService;
import com.kharidlo.service.userRegistration.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRegistrationController {

    @Autowired
    IUserRegistrationService userRegistrationService;

    @PostMapping
    public int post(User klUser) {
        return userRegistrationService.create(klUser).getId();
    }
}
