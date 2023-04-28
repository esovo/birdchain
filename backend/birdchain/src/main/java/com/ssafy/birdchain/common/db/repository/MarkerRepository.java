package com.ssafy.birdchain.common.db.repository;

import com.ssafy.birdchain.common.db.entity.Marker;
import com.ssafy.birdchain.common.db.repository.querydsl.MarkerRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MarkerRepository extends JpaRepository<Marker, Long>, MarkerRepositoryCustom {

}
