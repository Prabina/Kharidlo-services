package com.kharidlo.service.authentication.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER_AUTHENTICATION_TOKEN")
public class UserAuthenticationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name="EMAIL_ID")
    private String emailId;

    @Column(name = "AUTH_TOKEN")
    private String authenticationToken;

    public UserAuthenticationToken() {
        //Default Constructor
    }
}
