package com.ssafy.birdchain.common.db.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Marker extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marker_id", nullable = false)
    private Long id;

    @Column(name = "marker_nickname", nullable = false)
    private String nickname;

    @Column(name = "marker_type", nullable = false)
    private String type;

    @Column(name = "marker_lng", nullable = false)
    private Double lng;

    @Column(name = "marker_lat", nullable = false)
    private Double lat;

    @Column(name = "marker_location", nullable = false)
    private String location;

    @Column(name = "marker_image", nullable = false)
    private String image;

    @Column(name = "marker_content", nullable = false)
    private String content;

    @Column(name = "marker_password", nullable = false)
    private String password;

    @Column(name = "marker_status", nullable = false)
    private Boolean status;
}