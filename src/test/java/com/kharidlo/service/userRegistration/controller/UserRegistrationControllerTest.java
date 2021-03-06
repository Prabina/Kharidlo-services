package com.kharidlo.service.userRegistration.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.kharidlo.service.userRegistration.entity.User;
import com.kharidlo.service.userRegistration.service.UserRegistrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserRegistrationController.class)
public class UserRegistrationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRegistrationService userRegistrationService;

    @Test
    public void shouldReturnOKForSuccessfulLogin() throws Exception {
        User user = User.builder().fullName("Abhisek Harh").password("abcd").emailId("abhisek@gmail.com").phoneNumber("1234567891").build();
        ObjectMapper mapper = new ObjectMapper();
        when(userRegistrationService.create(Mockito.any(User.class))).thenReturn(User.builder().id(1).build());
        this.mockMvc.perform(post("/register").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(user)))
                .andExpect(status().isOk());
    }
}
