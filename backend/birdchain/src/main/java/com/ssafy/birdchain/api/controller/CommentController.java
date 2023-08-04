package com.ssafy.birdchain.api.controller;

import com.ssafy.birdchain.api.service.CommentService;
import com.ssafy.birdchain.common.db.dto.request.comment.CommentAddReqDTO;
import com.ssafy.birdchain.common.db.dto.request.comment.CommentDeleteReqDTO;
import com.ssafy.birdchain.common.db.dto.request.comment.CommentModifyReqDTO;
import com.ssafy.birdchain.common.db.dto.util.ResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Log4j2
@RestController
@Tag(name = "댓글 API")
@RequiredArgsConstructor
@RequestMapping(value = "/map/comments")
public class CommentController {

    private final CommentService commentService;

    @GetMapping
    @Operation(summary = "댓글 조회")
    public ResponseEntity<ResponseDTO> commentAllList(@RequestParam Long id) {
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "조회에 성공했습니다.", commentService.findAllComment(id)));
    }

    @PostMapping
    @Operation(summary = "댓글 등록")
    public ResponseEntity<ResponseDTO> commentAdd(@RequestBody CommentAddReqDTO commentAddReqDTO) {
        commentService.addComment(commentAddReqDTO);
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "등록에 성공했습니다."));
    }

    @PutMapping
    @Operation(summary = "댓글 수정")
    public ResponseEntity<ResponseDTO> commentModify(@RequestBody CommentModifyReqDTO commentModifyReqDTO) {
        commentService.modifyComment(commentModifyReqDTO);
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "수정에 성공했습니다."));
    }

    @PutMapping("/delete")
    @Operation(summary = "댓글 삭제")
    public ResponseEntity<ResponseDTO> commentDelete(@RequestBody CommentDeleteReqDTO commentDeleteReqDTO) throws IOException {
        commentService.deleteMarker(commentDeleteReqDTO);
        return ResponseEntity.ok().body(ResponseDTO.of(HttpStatus.OK, "삭제에 성공했습니다."));
    }
}