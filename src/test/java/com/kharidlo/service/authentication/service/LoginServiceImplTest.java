package com.kharidlo.service.authentication.service;

import com.kharidlo.service.authentication.authenticationlogic.AuthenticationLogic;
import com.kharidlo.service.authentication.exception.LoginFailureException;
import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginServiceImplTest {

    @Mock
    private AuthenticationLogic authenticationLogic;

    @Mock
    private UserLoginRepository userLoginRepository;

    @Autowired
    private LoginService loginService;

    @Mock
    User mockedUser;


    @Before
    public void setUp(){
        loginService = LoginServiceImpl.builder().authenticationLogic(authenticationLogic).userLoginRepository(userLoginRepository).build();
    }

    @Test
    public void shouldSuccessfullyLoggedIn() throws LoginFailureException {
        AuthenticationCredentials authenticationCredentials = AuthenticationCredentials.builder()
                .emailId("abhisek@gmail.com")
                .password("thoughtworks").build();
        String emailId = authenticationCredentials.getEmailId();
        when(userLoginRepository.findUserByEmailId(emailId)).thenReturn(mockedUser);
        when(authenticationLogic.validateCredentials(Mockito.any(AuthenticationCredentials.class), Mockito.any(User.class)))
                .thenReturn(AuthenticationToken.builder().token("abcdef4567fghj").build());

        AuthenticationToken generatedToken = loginService.login(authenticationCredentials);
        Assert.assertEquals("abcdef4567fghj", generatedToken.getToken());
    }

    @Test(expected = LoginFailureException.class)
    public void shouldThrowExceptionWhenCredentialsNotMatch() throws LoginFailureException {
        AuthenticationCredentials authenticationCredentials = AuthenticationCredentials.builder()
                .emailId("abhisek@gmail.com")
                .password("thoughtworks").build();
        when(userLoginRepository.findUserByEmailId(Mockito.anyString())).thenReturn(mockedUser);
        when(authenticationLogic.validateCredentials(any(AuthenticationCredentials.class), any(User.class))).thenThrow(new LoginFailureException());
        loginService.login(authenticationCredentials);
    }
}
