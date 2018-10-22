package com.kharidlo.service.userRegistration.service;

import com.kharidlo.service.userRegistration.entity.User;
import com.kharidlo.service.userRegistration.repository.UserRegistrationRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRegistrationServiceTest {

    @Mock
    private UserRegistrationRepository userRegistrationRepository;

    @Test
    public void shouldCallCreateOnRepositoryAndReturnUser()
    {
        UserRegistrationService userRegistrationService = new UserRegistrationService(userRegistrationRepository);

        when(userRegistrationRepository.save(Mockito.any(User.class))).thenReturn(User.builder().id(1).build());

        assertEquals(userRegistrationService.create(User.builder().id(1).build()).getId(),1);
    }

    @Test
    public void shouldReturnNullIfUserAlreadyExists()
    {
        UserRegistrationService userRegistrationService = new UserRegistrationService(userRegistrationRepository);

        when(userRegistrationRepository.findUserByEmailId("a@b.com")).thenReturn(User.builder().emailId("a@b.com").build());
        when(userRegistrationRepository.save(Mockito.any(User.class))).thenReturn(User.builder().id(1).build());

        assertNull(userRegistrationService.create(User.builder().id(1).emailId("a@b.com").build()));
    }
}
