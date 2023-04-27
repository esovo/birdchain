package com.ssafy.birdchain.common.db.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Marker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marker_id")
    private Long id;

    @Column(name = "marker_nickname")
    private String nickname;

    @Column(name = "marker_type")
    private String type;

    @Column(name = "marker_lan")
    private Double lan;

    @Column(name = "marker_lat")
    private Double lat;

    @Column(name = "marker_image")
    private String image;

    @Column(name = "marker_content")
    private String content;

    @Column(name = "marker_password")
    private String password;

}
