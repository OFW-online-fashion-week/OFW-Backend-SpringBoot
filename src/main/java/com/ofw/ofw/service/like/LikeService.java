package com.ofw.ofw.service.like;

import com.ofw.ofw.payload.like.response.LikeBrandListResponse;

public interface LikeService {

    void userLikeBrand(Long brandId, Long userId);

    void userUnlikeBrand(Long brandId, Long userId);

    LikeBrandListResponse getLikeBrandList(Long userId);

    boolean isLike(Long brandId, Long userId);
}
