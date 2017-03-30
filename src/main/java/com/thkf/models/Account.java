package com.thkf.models;

import com.sun.istack.internal.Nullable;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Nullable
    @Enumerated(EnumType.STRING)
    @Column(name = "LOGIN_WITH")
    private LoginWith loginWith;

    @Nullable
    @Column(name = "FIRST_NAME")
    private String firstName;

    @Nullable
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Nullable
    @Column(name = "PRIMARY_EMAIL")
    private String primaryEmail;

    @Nullable
    @Column(name = "SECONDARY_EMAIL")
    private String secondaryEmail;

    @Nullable
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Nullable
    @Column(name = "ADDRESS")
    private String address;

    @Nullable
    @Column(name = "PIN_CODE")
    private String pinCode;

    @Nullable
    @Column(name = "QUESTION")
    private String question;

    @Nullable
    @Column(name = "ANSWER")
    private String answer;

    @Nullable
    @Column(name = "URL")
    private String url;

    @Nullable
    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Nullable
    @Column(name = "DESCRIPTION")
    private String description;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
