package com.kharidlo.service.authentication.controller;

import com.kharidlo.service.authentication.model.AuthenticationCredentials;
import com.kharidlo.service.authentication.model.AuthenticationToken;
import com.kharidlo.service.authentication.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoginService loginService;

    @Test
    public void shouldReturnOKForSuccessfulLogin() throws Exception {
        String requestBody = "{\n" +
                "\t\"emailId\":\"Test\",\n" +
                "\t\"password\":\"qwert\"\n" +
                "}";
        AuthenticationToken token = AuthenticationToken.builder().token("abcd123fdhjdjk").build();
        when(loginService.login(Mockito.any(AuthenticationCredentials.class))).thenReturn(Optional.of(token));

        this.mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(requestBody))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.token").value("abcd123fdhjdjk"));
    }

   @Test
    public void shouldThrowLoginFailureExceptionOnLoginFailure() throws Exception {
       String requestBody = "{\n" +
               "\t\"emailId\":\"Test\",\n" +
               "\t\"password\":\"qwert\"\n" +
               "}";
        when(loginService.login(Mockito.any(AuthenticationCredentials.class))).thenReturn(Optional.ofNullable(null));

        this.mockMvc.perform(post("/login").contentType(MediaType.APPLICATION_JSON).content(requestBody))
        .andExpect(status().isForbidden())
        .andExpect(jsonPath("$.message").value("Invalid Credentials"));
    }
}
