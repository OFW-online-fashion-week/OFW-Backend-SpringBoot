package com.ofw.ofw.service.image;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AmazonS3Service {

    String uploadFile(MultipartFile file) throws IOException;
}
