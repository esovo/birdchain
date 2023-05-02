package com.ssafy.birdchain.api.controller;

import com.ssafy.birdchain.api.service.MarkerService;
import com.ssafy.birdchain.common.db.dto.request.MarkerAddReqDTO;
import com.ssafy.birdchain.common.db.dto.util.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Log4j2
@RestController
@Api(tags = {"마커 API"})
@RequiredArgsConstructor
@RequestMapping(value = "/map/markers")
public class MarkerController {

    private final MarkerService markerService;

    @GetMapping
    @ApiOperation(value = "전체 마커 조회")
    public ResponseEntity<ResponseDTO> markerAllList(@RequestParam String type) {
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "조회에 성공했습니다.", markerService.findAllMarker(type)));
    }

    @GetMapping("/detail")
    @ApiOperation(value = "마커 상세 조회")
    public ResponseEntity<ResponseDTO> markerDetail(@RequestParam Long id){
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "조회에 성공했습니다.", markerService.findMarker(id)));
    }

    @PostMapping
    @ApiOperation(value = "마커 등록")
    public ResponseEntity<ResponseDTO> markerAdd(@RequestPart(value = "markerAddReqDTO") MarkerAddReqDTO markerAddReqDTO, @RequestPart(value = "file") MultipartFile multipartFile) throws IOException {
        markerService.addMarker(markerAddReqDTO, multipartFile);
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "등록에 성공했습니다."));
    }

}
