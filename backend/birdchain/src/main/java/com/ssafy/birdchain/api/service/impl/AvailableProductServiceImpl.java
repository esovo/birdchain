package com.ssafy.birdchain.api.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.ssafy.birdchain.api.service.AvailableProductService;
import com.ssafy.birdchain.common.db.entity.AvailableProduct;
import com.ssafy.birdchain.common.db.repository.AvailableProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

@Service
public class AvailableProductServiceImpl implements AvailableProductService {

    @Autowired
    private AvailableProductRepository availableProductRepository;
    @Autowired
    private AmazonS3 amazonS3;

    @PostConstruct
    public void init() {
        for (int i=1; i <= 315; i++) {
            AvailableProduct availableProduct = new AvailableProduct();
            availableProduct.setId(i);
            availableProduct.setAvailable(true);
            availableProductRepository.save(availableProduct);
        }
    }

    @Override
    public int giveMeNFTNumber() {
        List<AvailableProduct> availableProducts = availableProductRepository.findByIsAvailable(true);
        if (availableProducts.isEmpty()) {
            return -1;
        } else {
            int randomNumber = (int) (Math.random() * availableProducts.size());
            AvailableProduct randomProduct = availableProducts.get(randomNumber);
            randomProduct.setAvailable(false);
            availableProductRepository.save(randomProduct);
            int targetNumber = randomProduct.getId();
            return targetNumber;
        }
    }

    @Override
    public URL getFileUrl(String fileName) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest("birdchain", "NFTimages/" + fileName + ".png");
        URL fileUrl = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
        return fileUrl;
    }
}
