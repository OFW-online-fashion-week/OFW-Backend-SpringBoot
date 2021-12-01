package com.ofw.ofw.service.brand;

import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;
import com.ofw.ofw.payload.brand.response.BrandDetailResponse;
import com.ofw.ofw.payload.brand.response.BrandListResponse;

public interface BrandService {

    BrandListResponse getBrandList(String filter);

    BrandDetailResponse getBrandDetail(Long brandId);

    void updateBrand(AuthRequestBrandRegisteringRequest request);
}
