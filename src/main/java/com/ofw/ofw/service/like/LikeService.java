package com.ofw.ofw.service.like;

import com.ofw.ofw.payload.like.response.LikeBrandListResponse;

public interface LikeService {

    void userLikeBrand(Long brandId);

    void userUnlikeBrand(Long brandId);

    LikeBrandListResponse getLikeBrandList();

    boolean isLike(Long brandId);
}
