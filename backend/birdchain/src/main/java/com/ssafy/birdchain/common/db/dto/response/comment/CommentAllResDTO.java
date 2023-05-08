package com.ssafy.birdchain.common.db.dto.response.comment;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "댓글 id")
    private Long id;

    @Schema(description = "댓글 작성자 닉네임")
    private String nickname;

    @Schema(description = "댓글 내용")
    private String content;

    @Schema(description = "댓글 생성일자")
    private LocalDateTime createdAt;

}
