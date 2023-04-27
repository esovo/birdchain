package com.ssafy.birdchain.api.service;

import com.ssafy.birdchain.common.db.dto.request.MarkerAddReqDTO;
import com.ssafy.birdchain.common.db.dto.response.MarkerAllResDTO;

import java.util.List;

public interface MarkerService {

    List<MarkerAllResDTO> findAllMarker(String type);
    void addMarker(MarkerAddReqDTO markerAddReqDTO);

}
