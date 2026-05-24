package com.sms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private Double balance;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String token;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
