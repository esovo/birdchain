package com.ssafy.birdchain.common.db.dto.request.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
public class CommentAddReqDTO {

    private String nickname;

    private String content;

    private String password;

    private Long markerId;

}