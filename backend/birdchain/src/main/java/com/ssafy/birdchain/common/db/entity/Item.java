package com.ssafy.birdchain.common.db.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id", nullable = false)
    private Long id;

    @Column(name = "item_image_url", nullable = false)
    private String imageUrl;

    @Column(name = "item_keyword")
    private String keyword;

    @Column(name = "item_owner_address")
    private String ownerAddress;

    @Column(name = "item_name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "donation_id", nullable = false)
    private Donation donation;

}
