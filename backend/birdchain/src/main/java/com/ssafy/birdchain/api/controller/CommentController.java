package com.ssafy.birdchain.api.controller;

import com.ssafy.birdchain.api.service.CommentService;
import com.ssafy.birdchain.common.db.dto.request.CommentAddReqDTO;
import com.ssafy.birdchain.common.db.dto.util.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@Api(tags = {"댓글 API"})
@RequiredArgsConstructor
@RequestMapping(value = "/map/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    @ApiOperation(value = "댓글 조회")
    public ResponseEntity<ResponseDTO> commentAllList(@RequestParam Long id) {
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "조회에 성공했습니다.", commentService.findAllComment(id)));
    }

    @PostMapping
    @ApiOperation(value = "댓글 등록")
    public ResponseEntity<ResponseDTO> commentAdd(@RequestBody CommentAddReqDTO commentAddReqDTO) {
        commentService.addComment(commentAddReqDTO);
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "등록에 성공했습니다."));
    }

}
