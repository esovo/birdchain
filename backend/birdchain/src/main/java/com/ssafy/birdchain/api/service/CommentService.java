package com.ssafy.birdchain.api.service;

import com.ssafy.birdchain.common.db.dto.request.comment.CommentAddReqDTO;
import com.ssafy.birdchain.common.db.dto.request.comment.CommentDeleteReqDTO;
import com.ssafy.birdchain.common.db.dto.request.comment.CommentModifyReqDTO;
import com.ssafy.birdchain.common.db.dto.response.comment.CommentAllResDTO;

import java.util.List;

public interface CommentService {
    List<CommentAllResDTO> findAllComment(Long id);

    void addComment(CommentAddReqDTO commentAddReqDTO);

    void modifyComment(CommentModifyReqDTO commentModifyReqDTO);

    void deleteMarker(CommentDeleteReqDTO commentDeleteReqDTO);
}
