package com.kharidlo.service.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class AuthenticationCredentials {

    private String emailId;
    private String password;
}
