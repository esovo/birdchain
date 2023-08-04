package com.ssafy.birdchain.common.db.dto.response.marker;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MarkerAllResDTO {

    @Schema(description = "마커 아이디")
    private Long id;

    @Schema(description = "마커 유형")
    private String type;

    @Schema(description = "마커 경도")
    private Double lng;

    @Schema(description = "마커 위도")
    private Double lat;

    @Schema(description = "마커 첨부 이미지")
    private String image;

}