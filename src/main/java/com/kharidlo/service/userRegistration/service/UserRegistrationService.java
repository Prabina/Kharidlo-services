package com.kharidlo.service.userRegistration.service;

import com.kharidlo.service.userRegistration.entity.User;
import com.kharidlo.service.userRegistration.repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService implements IUserRegistrationService {

    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

    public UserRegistrationService(UserRegistrationRepository userRegistrationRepository) {
        this.userRegistrationRepository = userRegistrationRepository;
    }

    @Override
    public User create(User klUser) {
        return userRegistrationRepository.save(klUser);
    }
}