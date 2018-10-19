package com.kharidlo.service.authentication.service;

import com.kharidlo.service.authentication.exception.LoginFailureException;
import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;

public interface LoginService {
    AuthenticationToken login(AuthenticationCredentials credentials) throws LoginFailureException;
}
