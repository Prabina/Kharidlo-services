package com.kharidlo.service.userRegistration.repository;

import com.kharidlo.service.userRegistration.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends CrudRepository<User, Integer> {

}
