package com.kharidlo.service.userRegistration.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Builder
@AllArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "EMAIL_ID")
    private String emailId;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    public User(){}
}
