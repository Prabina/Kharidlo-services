package com.kharidlo.service.authentication.service;

import com.kharidlo.service.authentication.authenticationlogic.AuthenticationLogic;
import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;
import com.kharidlo.service.authentication.repository.UserAuthenticationTokenRepository;
import com.kharidlo.service.authentication.repository.UserLoginRepository;
import com.kharidlo.service.userRegistration.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

    private final String EMAIL_ID = "abhisek@gmail.com";
    private final String PASSWORD = "thoughtworks";

    @Mock
    private AuthenticationLogic authenticationLogic;

    @Mock
    private UserLoginRepository userLoginRepository;

    @Mock
    private UserAuthenticationTokenRepository userAuthTokenRepository;

    private LoginService loginService;

    @Mock
    User mockedUser;

    @Before
    public void setUp(){
        loginService = new LoginServiceImpl(authenticationLogic, userLoginRepository, userAuthTokenRepository);
    }

    @Test
    public void shouldSuccessfullyLoggedIn() {
        AuthenticationCredentials authenticationCredentials = AuthenticationCredentials.builder()
                .emailId(EMAIL_ID)
                .password(PASSWORD).build();
        String emailId = authenticationCredentials.getEmailId();
        when(userLoginRepository.findUserByEmailId(emailId)).thenReturn(mockedUser);
        when(authenticationLogic.validateCredentials(Mockito.any(AuthenticationCredentials.class), Mockito.any(User.class)))
                .thenReturn(Optional.of(AuthenticationToken.builder().token("abcdef4567fghj").build()));
        AuthenticationToken generatedToken = loginService.login(authenticationCredentials).get();
        Assert.assertEquals("abcdef4567fghj", generatedToken.getToken());
    }

    @Test
    public void shouldReturnNullWhenCredentialsNotMatch() {
        AuthenticationCredentials authenticationCredentials = AuthenticationCredentials.builder()
                .emailId(EMAIL_ID)
                .password(PASSWORD).build();
        when(userLoginRepository.findUserByEmailId(Mockito.anyString())).thenReturn(mockedUser);
        when(authenticationLogic.validateCredentials(any(AuthenticationCredentials.class), any(User.class))).thenReturn(Optional.ofNullable(null));
        Assert.assertFalse(loginService.login(authenticationCredentials).isPresent());
    }

    @Test
    public void shouldReturnNullWhenUserNotFound() {
        AuthenticationCredentials authenticationCredentials = AuthenticationCredentials.builder()
                .emailId(EMAIL_ID)
                .password(PASSWORD).build();
        when(userLoginRepository.findUserByEmailId(Mockito.anyString())).thenReturn(null);
        Assert.assertFalse(loginService.login(authenticationCredentials).isPresent());
    }
}
