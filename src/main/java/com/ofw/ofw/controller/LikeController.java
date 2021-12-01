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
    public String likeBrand(@RequestParam("brand_id") Long brandId) {
        likeService.userLikeBrand(brandId);
        return "success";
    }

    @DeleteMapping
    public String unlikeBrand(@RequestParam("brand_id") Long brandId) {
        likeService.userUnlikeBrand(brandId);
        return "success";
    }

    @GetMapping
    public LikeBrandListResponse likeBrands() {
        return likeService.getLikeBrandList();
    }

    @GetMapping("/is")
    public boolean isUserLikeBrand(@RequestParam("brand_id") Long brandId) {
        return likeService.isLike(brandId);
    }
}
