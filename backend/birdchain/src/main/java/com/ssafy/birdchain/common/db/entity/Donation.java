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
    @Column(name = "donation_id", nullable = false)
    private Long id;

    @Column(name = "donation_amount", nullable = false)
    private Double amount;

    @Column(name = "donation_created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "donation_transaction_hash", nullable = false)
    private String transactionHash;

}
