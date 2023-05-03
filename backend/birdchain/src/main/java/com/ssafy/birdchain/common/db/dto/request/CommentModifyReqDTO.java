package com.ssafy.birdchain.common.db.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentModifyReqDTO {

    private Long id;

    private String nickname;

    private String content;

    private String password;

    private Long markerId;

}
