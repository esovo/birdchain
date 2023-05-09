package com.ssafy.birdchain.common.db.dto.request.comment;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentDeleteReqDTO {

    @Schema(description = "댓글 id")
    private Long id;

    @Schema(description = "댓글 작성자 닉네임")
    private String nickname;

    @Schema(description = "댓글 비밀번호")
    private String password;

    @Schema(description = "마커 id")
    private Long markerId;

}
