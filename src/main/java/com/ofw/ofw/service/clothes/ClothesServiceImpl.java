package com.ofw.ofw.service.clothes;

import com.ofw.ofw.entity.brand.BrandRepository;
import com.ofw.ofw.entity.clothes.Clothes;
import com.ofw.ofw.entity.clothes.ClothesRepository;
import com.ofw.ofw.exception.type.BrandNotFoundException;
import com.ofw.ofw.payload.clothes.request.ClothesPostRequest;
import com.ofw.ofw.payload.clothes.response.ClothesDetailContentResponse;
import com.ofw.ofw.payload.clothes.response.ClothesDetailListResponse;
import com.ofw.ofw.payload.clothes.response.ClothesSearchContentResponse;
import com.ofw.ofw.payload.clothes.response.ClothesSearchListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ClothesServiceImpl implements ClothesService {

    private final ClothesRepository clothesRepository;
    private final BrandRepository brandRepository;

    @Override
    public ClothesSearchListResponse getSearchList(String filter) {
        List<Clothes> clothesList = clothesRepository.findByNameStartsWithIgnoreCase(filter);
        List<ClothesSearchContentResponse> clothesContentList = new ArrayList<>();

        for (Clothes clothes : clothesList) {
            clothesContentList.add(
                    ClothesSearchContentResponse.builder()
                            .id(clothes.getId())
                            .name(clothes.getName())
                            .styleCode(clothes.getStyleCode())
                            .build()
            );
        }

        return new ClothesSearchListResponse(clothesContentList);
    }

    @Override
    public ClothesDetailListResponse getClothesDetail(Long brandId) {
        List<Clothes> clothesList = clothesRepository.findAllByBrand(brandRepository.findById(brandId)
                .orElseThrow(BrandNotFoundException::new));
        List<ClothesDetailContentResponse> clothesContentList = new ArrayList<>();

        for (Clothes clothes : clothesList) {
            clothesContentList.add(
                    ClothesDetailContentResponse.builder()
                            .name(clothes.getName())
                            .styleCode(clothes.getStyleCode())
                            .url(clothes.getUrl())
                            .description(clothes.getDescription())
                            .imagePath(clothes.getImage_path())
                            .build()
            );
        }

        return new ClothesDetailListResponse(clothesContentList);
    }

    @Override
    public void postClothes(ClothesPostRequest request) {
        clothesRepository.save(
                Clothes.builder()
                        .name(request.getName())
                        .styleCode(request.getStyleCode())
                        .url(request.getName())
                        .description(request.getDescription())
                        .image_path(request.getImagePath())
                        .build()
        );
    }
}
