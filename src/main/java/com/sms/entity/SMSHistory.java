package com.sms.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "sms_history")
public class SMSHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_token")
    private String userToken;

    @Column
    private String phone;

    @Column
    private String message;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
