package com.kharidlo.service.authentication.authenticationlogic;

import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;
import com.kharidlo.service.userRegistration.entity.User;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthenticationLogic {

    private AuthenticationToken generateToken(User user){

        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return AuthenticationToken.builder()
                .token(RandomStringUtils.random(length, useLetters, useNumbers)).role(user.getRole()).build();
    }

    public Optional<AuthenticationToken> validateCredentials(AuthenticationCredentials authenticationCredentials, User  user) {

        AuthenticationCredentials that = AuthenticationCredentials.builder()
                .emailId(user.getEmailId()).password(user.getPassword()).build();

        if(!authenticationCredentials.equals(that))
            return Optional.ofNullable(null);

        return Optional.ofNullable(generateToken(user));

    }
}
