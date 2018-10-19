package com.kharidlo.service.UserRegistration.Repository;

import com.kharidlo.service.UserRegistration.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepository extends CrudRepository<User, Integer> {

}
