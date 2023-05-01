package com.ssafy.birdchain.common.db.repository.querydsl;

import com.ssafy.birdchain.common.db.dto.response.MarkerAllResDTO;
import com.ssafy.birdchain.common.db.dto.response.MarkerResDTO;

import java.util.List;
import java.util.Optional;

public interface MarkerRepositoryCustom {

    List<MarkerAllResDTO> findAllByType(String type);
    Optional<MarkerResDTO> findById(Long id);
}
