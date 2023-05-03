package com.ssafy.birdchain.api.service;

import com.ssafy.birdchain.common.db.dto.request.CommentAddReqDTO;
import com.ssafy.birdchain.common.db.dto.request.CommentDeleteReqDTO;
import com.ssafy.birdchain.common.db.dto.request.CommentModifyReqDTO;
import com.ssafy.birdchain.common.db.dto.response.CommentAllResDTO;

import java.util.List;

public interface CommentService {
    List<CommentAllResDTO> findAllComment(Long id);

    void addComment(CommentAddReqDTO commentAddReqDTO);

    void modifyComment(CommentModifyReqDTO commentModifyReqDTO);

    void deleteMarker(CommentDeleteReqDTO commentDeleteReqDTO);
}
