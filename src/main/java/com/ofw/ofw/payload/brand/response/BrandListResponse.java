package com.ofw.ofw.payload.brand.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BrandListResponse {

    private List<BrandContentResponse> brandContentResponseList;
}
