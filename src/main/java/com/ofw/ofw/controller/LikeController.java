package com.ofw.ofw.controller;

import com.ofw.ofw.payload.like.response.LikeBrandListResponse;
import com.ofw.ofw.service.like.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/like")
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public String likeBrand(@RequestParam Long brandId) {
        likeService.userLikeBrand(brandId);
        return "success";
    }

    @DeleteMapping
    public String unlikeBrand(@RequestParam Long brandId) {
        likeService.userUnlikeBrand(brandId);
        return "success";
    }

    @GetMapping
    public LikeBrandListResponse likeBrands() {
        return likeService.getLikeBrandList();
    }

    // isLike 맹글어
}
