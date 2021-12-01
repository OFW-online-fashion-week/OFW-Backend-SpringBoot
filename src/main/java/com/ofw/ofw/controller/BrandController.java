package com.ofw.ofw.controller;

import com.ofw.ofw.payload.brand.response.BrandDetailResponse;
import com.ofw.ofw.payload.brand.response.BrandListResponse;
import com.ofw.ofw.service.brand.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/brand")
@RestController
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public BrandListResponse brandList(@RequestParam("filter") String filter) {
        return brandService.getBrandList(filter);
    }

    @GetMapping("/{brand_id}")
    public BrandDetailResponse brandDetail(@PathVariable("brand_id") Long brandId) {
        return brandService.getBrandDetail(brandId);
    }

    @PutMapping
    public void updateBrandInfo() {

    }
}
