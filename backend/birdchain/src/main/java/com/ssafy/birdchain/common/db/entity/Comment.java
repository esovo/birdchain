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
    @Column(name = "comment_id")
    private Long id;

    @Column(name = "comment_nickname")
    private String nickname;

    @Column(name = "comment_content")
    private String content;

    @Column(name = "comment_password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "marker_id")
    private Marker marker;

}
