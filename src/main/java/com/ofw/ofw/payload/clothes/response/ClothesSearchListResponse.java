package com.ofw.ofw.payload.clothes.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClothesSearchListResponse {

    List<ClothesSearchContentResponse> clothesSearchContentResponseList;
}
