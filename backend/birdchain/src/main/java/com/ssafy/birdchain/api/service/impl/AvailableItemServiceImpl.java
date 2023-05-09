package com.ssafy.birdchain.api.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.ssafy.birdchain.api.service.AvailableItemService;
import com.ssafy.birdchain.common.db.entity.AvailableItem;
import com.ssafy.birdchain.common.db.repository.AvailableItemRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
public class AvailableItemServiceImpl implements AvailableItemService {

    @Autowired
    private AvailableItemRepository availableItemRepository;
    @Autowired
    private AmazonS3 amazonS3;

    @PostConstruct
    public void init() {
        for (int i=1; i <= 315; i++) {
            AvailableItem availableItem = new AvailableItem();
            availableItem.setId(i);
            availableItem.setAvailable(true);
            availableItemRepository.save(availableItem);
        }
    }

    @Override
    public int findAvailableItemNumber() {
        List<AvailableItem> availableItems = availableItemRepository.findByIsAvailable(true);
        if (availableItems.isEmpty()) {
            return -1;
        } else {
            int randomNumber = (int) (Math.random() * availableItems.size());
            AvailableItem randomProduct = availableItems.get(randomNumber);
            randomProduct.setAvailable(false);
            availableItemRepository.save(randomProduct);
            int targetNumber = randomProduct.getId();
            return targetNumber;
        }
    }

    @Override
    public URL findAvailableItemImageUrl(String fileName) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest("birdchain", "NFTimages/" + fileName + ".png");
        URL fileUrl = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
        return fileUrl;
    }
}
