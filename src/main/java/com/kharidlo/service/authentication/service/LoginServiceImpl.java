package com.kharidlo.service.authentication.service;

import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public boolean login(AuthenticationCredentials credentials) {
        return false;
    }
}
