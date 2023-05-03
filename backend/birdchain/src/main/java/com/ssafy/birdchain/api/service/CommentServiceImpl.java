package com.ssafy.birdchain.api.service;

import com.ssafy.birdchain.common.db.dto.request.CommentAddReqDTO;
import com.ssafy.birdchain.common.db.dto.response.CommentAllResDTO;
import com.ssafy.birdchain.common.db.entity.Comment;
import com.ssafy.birdchain.common.db.entity.Marker;
import com.ssafy.birdchain.common.db.repository.CommentRepository;
import com.ssafy.birdchain.common.db.repository.MarkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final MarkerRepository markerRepository;

    /**
     * 댓글 조회
     *
     * @param id
     * @return
     */
    @Override
    public List<CommentAllResDTO> findAllComment(Long markerId) {
        return commentRepository.findAllByMarkerId(markerId);
    }

    /**
     * 댓글 등록
     *
     * @param commentAddReqDTO
     */
    @Override
    public void addComment(CommentAddReqDTO commentAddReqDTO) {
        Marker marker = markerRepository.findById(commentAddReqDTO.getMarkerId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 마커입니다."));
        Comment comment = Comment.builder()
                .nickname(commentAddReqDTO.getNickname())
                .content(commentAddReqDTO.getContent())
                .password(commentAddReqDTO.getPassword())
                .marker(marker)
                .build();
        commentRepository.save(comment);
    }

}
