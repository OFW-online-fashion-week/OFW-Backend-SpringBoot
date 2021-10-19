package com.ofw.ofw.controller;

import com.ofw.ofw.service.image.AmazonS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class AmazonS3Controller {

    private final AmazonS3Service amazonS3Service;

    @PostMapping("/upload")
    public String upload(@RequestParam("image") MultipartFile multipartFile) throws IOException {
        amazonS3Service.uploadFile(multipartFile);
        return "success";
    }
}
