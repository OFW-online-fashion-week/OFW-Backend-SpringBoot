package com.ofw.ofw.service.image;

import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

public interface AmazonS3Service {

    String uploadFile(MultipartFile file) throws IOException;

    String getFileUrl(String fileName);
}
