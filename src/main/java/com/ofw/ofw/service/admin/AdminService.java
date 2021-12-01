package com.ofw.ofw.service.admin;

import com.ofw.ofw.payload.admin.response.AdminBrandDetailResponse;
import com.ofw.ofw.payload.admin.response.AdminBrandListResponse;

public interface AdminService {

    AdminBrandListResponse getBrandList();

    AdminBrandDetailResponse getBrandDetail(String brandId);

    void acceptBrand(String brandId);

    void rejectBrand(String brandId);

    void setTimeToLiveThree(String brandId);
}
