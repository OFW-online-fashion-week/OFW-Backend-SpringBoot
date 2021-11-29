package com.ofw.ofw.service.clothes;

import com.ofw.ofw.payload.clothes.request.ClothesPostRequest;
import com.ofw.ofw.payload.clothes.response.ClothesDetailListResponse;
import com.ofw.ofw.payload.clothes.response.ClothesSearchListResponse;

public interface ClothesService {

    ClothesSearchListResponse getSearchList(String filter);

    ClothesDetailListResponse getClothesDetail(Long brandId);

    void postClothes(ClothesPostRequest request);
}
