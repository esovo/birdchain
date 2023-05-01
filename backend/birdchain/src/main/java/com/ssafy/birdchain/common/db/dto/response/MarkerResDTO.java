package com.ssafy.birdchain.common.db.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public class MarkerResDTO {

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

    @Schema(description = "마커 첨부 이미지")
    private String image;

    @Schema(description = "마커 글 내용")
    private String content;

    @Schema(description = "마커 생성일자")
    private LocalDateTime createdAt;
}
