package com.ofw.ofw.service.admin;

import com.ofw.ofw.entity.auth.AuthBrandCache;
import com.ofw.ofw.entity.auth.AuthBrandCacheRepository;
import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.brand.BrandRepository;
import com.ofw.ofw.exception.type.BrandCacheNotFoundException;
import com.ofw.ofw.payload.admin.response.AdminBrandContentResponse;
import com.ofw.ofw.payload.admin.response.AdminBrandDetailResponse;
import com.ofw.ofw.payload.admin.response.AdminBrandListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

    private final AuthBrandCacheRepository authBrandCacheRepository;
    private final BrandRepository brandRepository;

    public AdminBrandListResponse getBrandList() {
        Iterable<AuthBrandCache> brandCacheList = authBrandCacheRepository.findAll();
        List<AdminBrandContentResponse> brandList = new ArrayList<>();

        for (AuthBrandCache cache : brandCacheList) {
            brandList.add(
                    AdminBrandContentResponse.builder()
                            .id(cache.getEmail().replace("brand:", ""))
                            .profileUrl(cache.getProfileFile())
                            .name(cache.getName())
                            .createdAt(cache.getCreatedAt())
                            .build()
            );
        }

        return new AdminBrandListResponse(brandList);
    }

    @Override
    public AdminBrandDetailResponse getBrandDetail(String brandId) {
        return authBrandCacheRepository.findById(brandId)
                .map(brand -> AdminBrandDetailResponse.builder()
                        .id(brand.getEmail().replace("brand:", ""))
                        .profileUrl(brand.getProfileFile())
                        .name(brand.getName())
                        .description(brand.getDescription())
                        .build())
                .orElseThrow(BrandCacheNotFoundException::new);
    }

    @Override
    public void acceptBrand(String brandId) {
        AuthBrandCache brandCache = authBrandCacheRepository.findById(brandId)
                .orElseThrow(BrandCacheNotFoundException::new);

        brandRepository.save(
                Brand.builder()
                        .email(brandCache.getEmail())
                        .profilePath(brandCache.getProfileFile())
                        .coverPath(brandCache.getCoverFile())
                        .password(brandCache.getPassword())
                        .name(brandCache.getName())
                        .url(brandCache.getUrl())
                        .description(brandCache.getDescription())
                        .build()
        );
        rejectBrand(brandId);
    }

    @Override
    public void rejectBrand(String brandId) {
        authBrandCacheRepository.deleteById(brandId);
    }

    @Override
    public void setTimeToLiveThree(String brandId) {
        AuthBrandCache brandCache = authBrandCacheRepository.findById(brandId)
                .orElseThrow(BrandCacheNotFoundException::new);
        brandCache.setTimeToLive(3);
        authBrandCacheRepository.save(brandCache);
    }
}
