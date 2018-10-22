package com.kharidlo.service.userRegistration.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@AllArgsConstructor
@Data
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

    public User(String fullName, String emailId, String password, String phoneNumber){
        this.fullName = fullName;
        this.emailId = emailId;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User(){}
}
