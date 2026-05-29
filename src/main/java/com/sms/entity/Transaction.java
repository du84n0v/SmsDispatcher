package com.sms.entity;

import com.sms.enums.TransactionTypeEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;

    @Column
    private Double amount;

    @Column
    private String description;

    @Column(name = "b_before")
    private Double balanceBefore;

    @Column(name = "b_after")
    private Double balanceAfter;

    @Column(name = "created_date")
    private LocalDateTime createdDate;
}
