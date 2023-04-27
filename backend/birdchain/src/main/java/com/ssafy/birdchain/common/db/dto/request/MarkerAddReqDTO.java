package com.ssafy.birdchain.common.db.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class MarkerAddReqDTO {

    @Schema(description = "마커 작성자 닉네임")
    private String nickname;

    @Schema(description = "마커 유형")
    private String type;

    @Schema(description = "마커 경도")
    private Double lan;

    @Schema(description = "마커 위도")
    private Double lat;

    @Schema(description = "마커 첨부 이미지")
    private String image;

    @Schema(description = "마커 글 내용")
    private String content;

    @Schema(description = "마커 비밀번호")
    private String password;

}
