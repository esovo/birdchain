package com.ssafy.birdchain.common.db.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
public class MarkerDeleteReqDTO {

    @Schema(description = "마커 id")
    private Long id;

    @Schema(description = "마커 작성자 닉네임")
    private String nickname;

    @Schema(description = "마커 비밀번호")
    private String password;

}
