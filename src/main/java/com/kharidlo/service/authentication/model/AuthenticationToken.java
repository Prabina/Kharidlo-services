package com.kharidlo.service.authentication.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationToken {
    private String token;
    private String role;

}
