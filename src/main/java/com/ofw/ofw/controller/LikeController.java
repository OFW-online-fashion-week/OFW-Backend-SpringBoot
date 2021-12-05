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
    public String likeBrand(@RequestParam("brand_id") Long brandId, @RequestParam("user_id") Long userId) {
        likeService.userLikeBrand(brandId, userId);
        return "success";
    }

    @DeleteMapping
    public String unlikeBrand(@RequestParam("brand_id") Long brandId, @RequestParam("user_id") Long userId) {
        likeService.userUnlikeBrand(brandId, userId);
        return "success";
    }

    @GetMapping
    public LikeBrandListResponse likeBrands(@RequestParam("user_id") Long userId) {
        return likeService.getLikeBrandList(userId);
    }

    @GetMapping("/is")
    public boolean isUserLikeBrand(@RequestParam("brand_id") Long brandId, @RequestParam("user_id") Long userId) {
        return likeService.isLike(brandId, userId);
    }
}
