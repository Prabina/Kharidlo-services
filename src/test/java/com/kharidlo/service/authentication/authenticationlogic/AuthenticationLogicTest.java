package com.kharidlo.service.authentication.authenticationlogic;

import com.kharidlo.service.authentication.exception.LoginFailureException;
import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;
import com.kharidlo.service.userRegistration.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationLogicTest {

    @InjectMocks
    private AuthenticationLogic authenticationLogic;

    @Test
    public void shouldReturnAuthenticationToken() throws LoginFailureException {
        AuthenticationCredentials authenticationCredentials = AuthenticationCredentials.builder()
                .emailId("abhisek@gmail.com").password("thoughtworks").build();
        User user = User.builder().emailId("abhisek@gmail.com").password("thoughtworks").build();

        AuthenticationToken token = authenticationLogic.validateCredentials(authenticationCredentials, user);
        Assert.assertNotNull(token.getToken());
    }

    @Test(expected = LoginFailureException.class)
    public void shouldThrowExceptionIfCredentialsNotMatch() throws LoginFailureException {
        AuthenticationCredentials authenticationCredentials = AuthenticationCredentials.builder()
                .emailId("abhisek@gmail.com").password("thoughtworks").build();
        User user = User.builder().emailId("abhisek@gmail.com").password("abc").build();
        authenticationLogic.validateCredentials(authenticationCredentials, user);
    }
}
