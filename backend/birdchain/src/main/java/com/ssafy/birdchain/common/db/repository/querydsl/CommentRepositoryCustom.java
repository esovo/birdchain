package com.ssafy.birdchain.common.db.repository.querydsl;

import com.ssafy.birdchain.common.db.dto.response.comment.CommentAllResDTO;

import java.util.List;

public interface CommentRepositoryCustom {

    List<CommentAllResDTO> findAllByMarkerId(Long markerId);

}