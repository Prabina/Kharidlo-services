package com.kharidlo.service.authentication.authenticationlogic;

import com.kharidlo.service.authentication.exception.LoginFailureException;
import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;
import com.kharidlo.service.userRegistration.entity.User;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationLogic {

    private AuthenticationToken generateToken(){

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return AuthenticationToken.builder()
                .token(RandomStringUtils.random(length, useLetters, useNumbers)).build();
    }

    public AuthenticationToken validateCredentials(AuthenticationCredentials authenticationCredentials, User user) throws LoginFailureException {

        AuthenticationCredentials that = AuthenticationCredentials.builder()
                .emailId(user.getEmailId()).password(user.getPassword()).build();

        if(!authenticationCredentials.equals(that))
            throw new LoginFailureException("login.faliure.invalid.username.password", "login.faliure.invalid.username.password");

        return generateToken();

    }
}
