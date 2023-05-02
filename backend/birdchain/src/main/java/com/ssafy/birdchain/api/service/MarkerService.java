package com.ssafy.birdchain.api.service;

import com.ssafy.birdchain.common.db.dto.request.MarkerAddReqDTO;
import com.ssafy.birdchain.common.db.dto.request.MarkerDeleteReqDTO;
import com.ssafy.birdchain.common.db.dto.request.MarkerModifyReqDTO;
import com.ssafy.birdchain.common.db.dto.response.MarkerAllResDTO;
import com.ssafy.birdchain.common.db.dto.response.MarkerResDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface MarkerService {

    List<MarkerAllResDTO> findAllMarker(String type);

    MarkerResDTO findMarker(Long id);

    void addMarker(MarkerAddReqDTO markerAddReqDTO, MultipartFile multipartFile) throws IOException;

    void modifyMarker(MarkerModifyReqDTO markerModifyReqDTO, MultipartFile multipartFile) throws IOException;

    void deleteMarker(MarkerDeleteReqDTO markerDeleteReqDTO);

}
