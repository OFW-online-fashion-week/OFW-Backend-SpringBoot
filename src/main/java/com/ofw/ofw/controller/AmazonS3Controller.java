package com.ofw.ofw.controller;

import com.ofw.ofw.service.image.AmazonS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class AmazonS3Controller {

    private final AmazonS3Service amazonS3Service;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.CREATED)
    public String upload(@RequestBody MultipartFile multipartFile) throws IOException {
        return amazonS3Service.uploadFile(multipartFile);
    }
}
