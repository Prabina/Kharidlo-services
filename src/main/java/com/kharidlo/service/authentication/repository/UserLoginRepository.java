package com.kharidlo.service.authentication.repository;

import com.kharidlo.service.userRegistration.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserLoginRepository extends CrudRepository<User, Integer> {
    @Query("Select u from User u where u.emailId = :emailId")
    User findUserByEmailId(@Param("emailId") String emailId);
}
