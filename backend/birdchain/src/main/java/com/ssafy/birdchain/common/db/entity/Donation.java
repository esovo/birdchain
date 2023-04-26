package com.ssafy.birdchain.common.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donation_id")
    private Long id;

    @Column(name = "donation_amount")
    private Double amount;

    @Column(name = "donation_created_at")
    private LocalDateTime createdAt;

    @Column(name = "donation_transaction_hash")
    private String transactionHash;

}
