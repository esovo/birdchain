package com.ssafy.birdchain.common.db.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Donation extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donation_id", nullable = false)
    private Long id;

    @Column(name = "donation_amount", nullable = false)
    private Double amount;

    @Column(name = "donation_transaction_hash", nullable = false)
    private String transactionHash;

    @Column(name = "donation_address", nullable = false)
    private String address;

}
