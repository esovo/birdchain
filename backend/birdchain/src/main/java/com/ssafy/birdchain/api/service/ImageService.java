package com.ssafy.birdchain.api.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;


public interface ImageService {

    // MultipartFile을 전달받아 File로 전환한 후 S3에 업로드
    String upload(MultipartFile multipartFile, String dirName) throws IOException;

    String upload(File uploadFile, String dirName);

    String putS3(File uploadFile, String fileName);

    void removeNewFile(File targetFile);

    Optional<File> convert(MultipartFile file) throws IOException;
}