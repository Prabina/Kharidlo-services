package com.kharidlo.service.UserRegistration;

import com.kharidlo.service.UserRegistration.Repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService implements IUserRegistrationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    @Override
    public User create(User klUser) {
        return userRegistrationRepository.save(klUser);
    }
}
