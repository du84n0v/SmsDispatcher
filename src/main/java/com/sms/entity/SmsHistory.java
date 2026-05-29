package com.sms.entity;

import com.sms.enums.SmsStatusEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "sms_history")
public class SmsHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Column
    private String phone;

    @Column
    private String text;

    @Column
    private Double price;

    @Enumerated(EnumType.STRING)
    private SmsStatusEnum status;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
