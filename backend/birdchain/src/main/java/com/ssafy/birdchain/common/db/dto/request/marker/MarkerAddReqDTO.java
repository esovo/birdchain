package com.ssafy.birdchain.common.db.dto.request.marker;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
public class MarkerAddReqDTO {

    @Schema(description = "마커 작성자 닉네임")
    private String nickname;

    @Schema(description = "마커 유형")
    private String type;

    @Schema(description = "마커 경도")
    private Double lan;

    @Schema(description = "마커 위도")
    private Double lat;

    @Schema(description = "마커 위치")
    private String location;

    @Schema(description = "마커 글 내용")
    private String content;

    @Schema(description = "마커 비밀번호")
    private String password;

}
