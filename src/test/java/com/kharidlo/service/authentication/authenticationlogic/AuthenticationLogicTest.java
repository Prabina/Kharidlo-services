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

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationLogicTest {

    @InjectMocks
    private AuthenticationLogic authenticationLogic;

    @Test
    public void shouldReturnAuthenticationToken() {
        AuthenticationCredentials authenticationCredentials = AuthenticationCredentials.builder()
                .emailId("abhisek@gmail.com").password("thoughtworks").build();
        User user = User.builder().emailId("abhisek@gmail.com").password("thoughtworks").build();

        Optional<AuthenticationToken> token = authenticationLogic.validateCredentials(authenticationCredentials, user);
        assertNotNull(token.get());
    }

    @Test
    public void shouldReturnNullIfCredentialsNotMatch() {
        AuthenticationCredentials authenticationCredentials = AuthenticationCredentials.builder()
                .emailId("abhisek@gmail.com").password("thoughtworks").build();
        User user = User.builder().emailId("abhisek@gmail.com").password("abc").build();
        assertFalse(authenticationLogic.validateCredentials(authenticationCredentials, user).isPresent());
    }
}
