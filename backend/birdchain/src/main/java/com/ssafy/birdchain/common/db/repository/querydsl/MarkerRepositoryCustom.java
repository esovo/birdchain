package com.ssafy.birdchain.common.db.repository.querydsl;

import com.ssafy.birdchain.common.db.dto.response.MarkerAllResDTO;

import java.util.List;

public interface MarkerRepositoryCustom {

    List<MarkerAllResDTO> findAllByType(String type);

}
