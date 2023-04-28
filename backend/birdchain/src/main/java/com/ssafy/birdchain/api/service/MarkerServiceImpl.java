package com.ssafy.birdchain.api.service;

import com.ssafy.birdchain.common.db.dto.request.MarkerAddReqDTO;
import com.ssafy.birdchain.common.db.dto.response.MarkerAllResDTO;
import com.ssafy.birdchain.common.db.entity.Marker;
import com.ssafy.birdchain.common.db.repository.MarkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MarkerServiceImpl implements MarkerService {

    private final MarkerRepository markerRepository;

    /**
     * 유형에 따른 마커 목록 조회
     * @param type
     * @return List<MarkerAllResDTO>
     */
    @Override
    public List<MarkerAllResDTO> findAllMarker(String type) {
        return markerRepository.findAllByType(type);
    }

    /**
     * 마커 등록
     * @param markerAddReqDTO
     */
    @Override
    public void addMarker(MarkerAddReqDTO markerAddReqDTO) {
        Marker marker = Marker.builder()
                .nickname(markerAddReqDTO.getNickname())
                .lat(markerAddReqDTO.getLat())
                .lan(markerAddReqDTO.getLan())
                .type(markerAddReqDTO.getType())
                .content(markerAddReqDTO.getContent())
                .password(markerAddReqDTO.getPassword())
                .build();
        markerRepository.save(marker);
    }
}
