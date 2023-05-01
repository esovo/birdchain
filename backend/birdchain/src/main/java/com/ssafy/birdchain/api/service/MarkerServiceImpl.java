package com.ssafy.birdchain.api.service;

import com.ssafy.birdchain.common.db.dto.request.MarkerAddReqDTO;
import com.ssafy.birdchain.common.db.dto.response.MarkerAllResDTO;
import com.ssafy.birdchain.common.db.dto.response.MarkerResDTO;
import com.ssafy.birdchain.common.db.entity.Marker;
import com.ssafy.birdchain.common.db.repository.MarkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MarkerServiceImpl implements MarkerService {

    private final MarkerRepository markerRepository;
    private final ImageService imageService;

    /**
     * 유형별 마커 목록 조회
     *
     * @param type
     * @return List<MarkerAllResDTO>
     */
    @Override
    public List<MarkerAllResDTO> findAllMarker(String type) {
        return markerRepository.findAllByType(type);
    }


    /**
     * 마커 상세 조회
     *
     * @param id
     * @return
     */
    @Override
    public MarkerResDTO findMarker(Long id) {
        return markerRepository.findById(id);
    }


    /**
     * 마커 등록
     *
     * @param markerAddReqDTO
     * @throws IOException
     */
    @Override
    public void addMarker(MarkerAddReqDTO markerAddReqDTO, MultipartFile multipartFile) throws IOException {
        String imageUrl = imageService.upload(multipartFile, "images");

        Marker marker = Marker.builder()
                .nickname(markerAddReqDTO.getNickname())
                .lat(markerAddReqDTO.getLat())
                .lan(markerAddReqDTO.getLan())
                .type(markerAddReqDTO.getType())
                .content(markerAddReqDTO.getContent())
                .password(markerAddReqDTO.getPassword())
                .image(imageUrl)
                .build();
        markerRepository.save(marker);
    }
}
