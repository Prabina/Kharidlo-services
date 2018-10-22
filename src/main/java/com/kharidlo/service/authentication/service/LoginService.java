package com.kharidlo.service.authentication.service;

import com.kharidlo.service.authentication.exception.LoginFailureException;
import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;

import java.util.Optional;

public interface LoginService {
    Optional<AuthenticationToken> login(AuthenticationCredentials credentials);
}
