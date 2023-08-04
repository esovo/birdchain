package com.ssafy.birdchain.common.db.repository;

import com.ssafy.birdchain.common.db.entity.Comment;
import com.ssafy.birdchain.common.db.repository.querydsl.CommentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long>, CommentRepositoryCustom {
}