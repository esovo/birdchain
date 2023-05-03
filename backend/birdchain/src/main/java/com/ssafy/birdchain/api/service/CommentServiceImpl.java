package com.ssafy.birdchain.api.service;

import com.ssafy.birdchain.common.db.dto.request.CommentAddReqDTO;
import com.ssafy.birdchain.common.db.dto.request.CommentDeleteReqDTO;
import com.ssafy.birdchain.common.db.dto.request.CommentModifyReqDTO;
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
     * @param markerId
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
                .status(true)
                .build();
        commentRepository.save(comment);
    }

    /**
     * 댓글 수정
     *
     * @param commentModifyReqDTO
     */
    @Override
    public void modifyComment(CommentModifyReqDTO commentModifyReqDTO) {
        Comment comment = commentRepository.findById(commentModifyReqDTO.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        if (comment.getNickname().equals(commentModifyReqDTO.getNickname()) && comment.getPassword().equals(commentModifyReqDTO.getPassword())) {
            comment.setContent(commentModifyReqDTO.getContent());
            commentRepository.save(comment);
        } else {
            throw new IllegalArgumentException("닉네임 또는 비밀번호가 일치하지 않습니다.");
        }
    }

    /**
     * 댓글 삭제
     *
     * @param commentDeleteReqDTO
     */
    @Override
    public void deleteMarker(CommentDeleteReqDTO commentDeleteReqDTO) {
        Comment comment = commentRepository.findById(commentDeleteReqDTO.getId()).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글입니다."));
        if (comment.getNickname().equals(commentDeleteReqDTO.getNickname()) && comment.getPassword().equals(commentDeleteReqDTO.getPassword())) {
            comment.setStatus(false);
            commentRepository.save(comment);
        } else {
            throw new IllegalArgumentException("닉네임 또는 비밀번호가 일치하지 않습니다.");
        }
    }

}
