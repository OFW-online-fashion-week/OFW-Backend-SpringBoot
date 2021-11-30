package com.ofw.ofw.service.brand;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.brand.BrandRepository;
import com.ofw.ofw.exception.type.BrandNotFoundException;
import com.ofw.ofw.payload.auth.request.AuthRequestBrandRegisteringRequest;
import com.ofw.ofw.payload.brand.response.BrandContentResponse;
import com.ofw.ofw.payload.brand.response.BrandDetailResponse;
import com.ofw.ofw.payload.brand.response.BrandListResponse;
import com.ofw.ofw.security.jwt.auth.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public BrandListResponse getBrandList(String filter) {
        List<Brand> brandList = brandRepository.findAllByNameStartsWithIgnoreCase(filter);
        return new BrandListResponse(
                brandList.stream().map(brand -> BrandContentResponse.builder()
                        .id(brand.getId())
                        .name(brand.getName())
                        .build()).collect(Collectors.toList())
        );
    }

    @Override
    public BrandDetailResponse getBrandDetail(Long brandId) {
        return brandRepository.findById(brandId)
                .map(brand -> BrandDetailResponse.builder()
                        .id(brand.getId())
                        .name(brand.getName())
                        .email(brand.getEmail())
                        .profileUrl(brand.getProfilePath())
                        .coverUrl(brand.getCoverPath())
                        .description(brand.getDescription())
                        .url(brand.getUrl())
                        .build())
                .orElseThrow(BrandNotFoundException::new);
    }

    @Override
    public void updateBrand(AuthRequestBrandRegisteringRequest request) {
        Brand brand = brandRepository.findById(authenticationFacade.getSub())
                .orElseThrow(BrandNotFoundException::new);
        brandRepository.save(brand);
    }
}
