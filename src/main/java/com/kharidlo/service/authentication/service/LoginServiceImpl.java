package com.kharidlo.service.authentication.service;

import com.kharidlo.service.authentication.authenticationlogic.AuthenticationLogic;
import com.kharidlo.service.authentication.entity.UserAuthenticationToken;
import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;
import com.kharidlo.service.authentication.repository.UserAuthenticationTokenRepository;
import com.kharidlo.service.authentication.repository.UserLoginRepository;
import com.kharidlo.service.userRegistration.entity.User;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private AuthenticationLogic authenticationLogic;

    private UserLoginRepository userLoginRepository;

    private UserAuthenticationTokenRepository userAuthTokenRepository;

    @Autowired
    public LoginServiceImpl(AuthenticationLogic authenticationLogic,
                            UserLoginRepository userLoginRepository,
                            UserAuthenticationTokenRepository userAuthTokenRepository) {
        this.authenticationLogic = authenticationLogic;
        this.userLoginRepository = userLoginRepository;
        this.userAuthTokenRepository = userAuthTokenRepository;
    }

    @Override
    public Optional<AuthenticationToken> login(AuthenticationCredentials credentials) {
        User user = userLoginRepository.findUserByEmailId(credentials.getEmailId());
        if(user == null) {
            return Optional.ofNullable(null);
        }

        Optional<AuthenticationToken> token = authenticationLogic.validateCredentials(credentials, user);
        if(token.isPresent()) {
            if(userAuthTokenRepository.findAuthTokenByEmailId(user.getEmailId()) != null){
                userAuthTokenRepository.updateAuthenticationTokenForEmailId(user.getEmailId(), token.get().getToken());
            } else {
                userAuthTokenRepository.save(UserAuthenticationToken.builder()
                        .authenticationToken(token.get().getToken()).emailId(user.getEmailId()).build());
            }
        }

        return token;
    }

    @Override
    public int logout(String emailId) {
        return userAuthTokenRepository.deleteTokenForEmailId(emailId);
    }
}
