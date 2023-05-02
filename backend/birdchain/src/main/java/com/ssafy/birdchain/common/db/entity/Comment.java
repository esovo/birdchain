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
public class Comment extends BaseTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id", nullable = false)
    private Long id;

    @Column(name = "comment_nickname", nullable = false)
    private String nickname;

    @Column(name = "comment_content", nullable = false)
    private String content;

    @Column(name = "comment_password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "marker_id", nullable = false)
    private Marker marker;

}
