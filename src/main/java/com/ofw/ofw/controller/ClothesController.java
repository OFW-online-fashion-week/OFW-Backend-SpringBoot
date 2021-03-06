package com.ofw.ofw.controller;

import com.ofw.ofw.payload.clothes.request.ClothesPostRequest;
import com.ofw.ofw.payload.clothes.response.ClothesDetailListResponse;
import com.ofw.ofw.payload.clothes.response.ClothesSearchListResponse;
import com.ofw.ofw.service.clothes.ClothesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clothes")
public class ClothesController {

    private final ClothesService clothesService;

    @GetMapping("/search")
    public ClothesSearchListResponse getSearchClothes(@RequestParam String filter) {
        return clothesService.getSearchList(filter);
    }

    @GetMapping("/{runway_id}")
    public ClothesDetailListResponse getClothes(@PathVariable("runway_id") Long runwayId) {
        return clothesService.getClothesDetail(runwayId);
    }

    @PostMapping
    public String createClothes(@RequestBody ClothesPostRequest request) {
        clothesService.postClothes(request);
        return "success";
    }
}
