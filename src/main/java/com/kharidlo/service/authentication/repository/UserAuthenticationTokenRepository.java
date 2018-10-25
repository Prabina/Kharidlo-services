package com.kharidlo.service.authentication.repository;

import com.kharidlo.service.authentication.entity.UserAuthenticationToken;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserAuthenticationTokenRepository extends CrudRepository<UserAuthenticationToken, Integer> {

    @Query("Select token from UserAuthenticationToken token where token.emailId = :emailId")
    UserAuthenticationToken findAuthTokenByEmailId(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query("Update UserAuthenticationToken token set token.authenticationToken = :authToken where token.emailId = :emailId")
    int updateAuthenticationTokenForEmailId(@Param("emailId") String emailId, @Param("authToken") String authToken);


    @Modifying
    @Transactional
    @Query("Delete from UserAuthenticationToken token where token.emailId = :emailId")
    int deleteTokenForEmailId(@Param("emailId") String emailId);

    @Query("Select token from UserAuthenticationToken token where token.authenticationToken = :authenticationToken")
    UserAuthenticationToken findAuthTokenByToken(@Param("authenticationToken") String authenticationToken);

}
