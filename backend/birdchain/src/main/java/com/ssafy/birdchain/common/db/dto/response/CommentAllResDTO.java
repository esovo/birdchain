package com.ssafy.birdchain.common.db.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentAllResDTO {

    private Long id;

    private String nickname;

    private String content;

    private LocalDateTime created_at;

}
