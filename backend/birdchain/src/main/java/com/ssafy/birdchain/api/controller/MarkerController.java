package com.ssafy.birdchain.api.controller;

import com.ssafy.birdchain.api.service.MarkerService;
import com.ssafy.birdchain.common.db.dto.request.marker.MarkerAddReqDTO;
import com.ssafy.birdchain.common.db.dto.request.marker.MarkerDeleteReqDTO;
import com.ssafy.birdchain.common.db.dto.request.marker.MarkerModifyReqDTO;
import com.ssafy.birdchain.common.db.dto.util.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Log4j2
@RestController
@Tag(name = "마커 API")
@RequiredArgsConstructor
@RequestMapping(value = "/map/markers")
public class MarkerController {

    private final MarkerService markerService;

    @GetMapping
    @Operation(summary = "전체 마커 조회")
    public ResponseEntity<ResponseDTO> markerAllList(@RequestParam String type) {
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "조회에 성공했습니다.", markerService.findAllMarker(type)));
    }

    @GetMapping("/detail")
    @Operation(summary = "마커 상세 조회")
    public ResponseEntity<ResponseDTO> markerDetail(@RequestParam Long id) {
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "조회에 성공했습니다.", markerService.findMarker(id)));
    }

    @PostMapping
    @Operation(summary = "마커 등록")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "마커 등록 성공"),
            @ApiResponse(responseCode = "400", description = "올바르지 않은 파일")
    })
    public ResponseEntity<ResponseDTO> markerAdd(@RequestPart(value = "markerAddReqDTO") MarkerAddReqDTO markerAddReqDTO, @RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
        if (markerService.validImgFile(multipartFile)) {
            markerService.addMarker(markerAddReqDTO, multipartFile);
            return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "등록에 성공했습니다."));
        }
        return ResponseEntity.badRequest().body(ResponseDTO.of(HttpStatus.BAD_REQUEST, "올바르지 않은 이미지 형식입니다."));
    }

    @PutMapping
    @Operation(summary = "마커 수정")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "마커 수정 성공"),
            @ApiResponse(responseCode = "400", description = "올바르지 않은 파일")
    })
    public ResponseEntity<ResponseDTO> markerModify(@RequestPart(value = "markerModifyReqDTO") MarkerModifyReqDTO markerModifyReqDTO, @RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
        if (markerService.validImgFile(multipartFile)) {
            markerService.modifyMarker(markerModifyReqDTO, multipartFile);
            return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "수정에 성공했습니다."));
        }
        return ResponseEntity.badRequest().body(ResponseDTO.of(HttpStatus.BAD_REQUEST, "올바르지 않은 이미지 형식입니다."));

    }

    @PutMapping("/delete")
    @Operation(summary = "마커 삭제")
    public ResponseEntity<ResponseDTO> markerDelete(@RequestBody MarkerDeleteReqDTO markerDeleteReqDTO) throws IOException {
        markerService.deleteMarker(markerDeleteReqDTO);
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "삭제에 성공했습니다."));
    }

}