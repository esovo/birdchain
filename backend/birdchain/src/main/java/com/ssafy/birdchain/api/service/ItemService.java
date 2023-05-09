package com.ssafy.birdchain.api.service;

import com.ssafy.birdchain.common.db.dto.request.item.ItemAddReqDTO;
import com.ssafy.birdchain.common.db.dto.response.item.ItemResDTO;

public interface ItemService {

    ItemResDTO findItem(Long id);

    void addItem(ItemAddReqDTO itemAddReqDTO);

}
