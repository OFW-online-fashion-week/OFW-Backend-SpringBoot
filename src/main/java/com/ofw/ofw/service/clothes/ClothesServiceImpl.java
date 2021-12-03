package com.ofw.ofw.service.clothes;

import com.ofw.ofw.entity.clothes.Clothes;
import com.ofw.ofw.entity.clothes.ClothesRepository;
import com.ofw.ofw.entity.clothes_has_runway.ClothesHasRunway;
import com.ofw.ofw.entity.clothes_has_runway.ClothesHasRunwayRepository;
import com.ofw.ofw.entity.runway.RunwayRepository;
import com.ofw.ofw.exception.type.RunwayNotFoundException;
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
    private final ClothesHasRunwayRepository clothesHasRunwayRepository;
    private final RunwayRepository runwayRepository;

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
    public ClothesDetailListResponse getClothesDetail(Long runwayId) {
        List<ClothesHasRunway> clothesHasRunwayList = clothesHasRunwayRepository.findAllByRunway(
                runwayRepository.findById(runwayId)
                        .orElseThrow(RunwayNotFoundException::new)
        );
        List<ClothesDetailContentResponse> clothesContentList = new ArrayList<>();

        for (ClothesHasRunway clothesHasRunway : clothesHasRunwayList) {
            Clothes clothes = clothesHasRunway.getClothes();
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
