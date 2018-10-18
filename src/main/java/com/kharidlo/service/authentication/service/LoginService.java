package com.kharidlo.service.authentication.service;

import com.kharidlo.service.authentication.model.AuthenticationCredentials;

public interface ILoginService {
    boolean login(AuthenticationCredentials credentials);
}
