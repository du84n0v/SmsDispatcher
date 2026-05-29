package com.sms.entity;

import com.sms.enums.ProfileStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_surname")
    private String ownerSurname;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private Double balance;

    @Enumerated(EnumType.STRING)
    private ProfileStatusEnum status;

    @Column
    private Boolean visible;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
