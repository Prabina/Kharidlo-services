package com.kharidlo.service.authentication.service;

import com.kharidlo.service.authentication.authenticationlogic.AuthenticationLogic;
import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;
import com.kharidlo.service.authentication.repository.UserLoginRepository;
import com.kharidlo.service.userRegistration.entity.User;
import com.kharidlo.service.userRegistration.repository.UserRegistrationRepository;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Builder
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationLogic authenticationLogic;

    @Autowired
    private UserLoginRepository userLoginRepository;


    @Override
    public Optional<AuthenticationToken> login(AuthenticationCredentials credentials) {
        User user = userLoginRepository.findUserByEmailId(credentials.getEmailId());
        return authenticationLogic.validateCredentials(credentials, user);
    }
}
