package com.ssafy.birdchain.common.db.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class CommentAddReqDTO {

    private String nickname;

    private String content;

    private String password;

    private Long markerId;

}
