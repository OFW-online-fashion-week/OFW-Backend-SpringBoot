package com.ofw.ofw.service.like;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.brand.BrandRepository;
import com.ofw.ofw.entity.like.Like;
import com.ofw.ofw.entity.like.LikeId;
import com.ofw.ofw.entity.like.LikeRepository;
import com.ofw.ofw.entity.user.UserRepository;
import com.ofw.ofw.exception.type.BrandNotFoundException;
import com.ofw.ofw.exception.type.UserNotFoundException;
import com.ofw.ofw.payload.like.response.LikeBrandContentResponse;
import com.ofw.ofw.payload.like.response.LikeBrandListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final BrandRepository brandRepository;

    @Override
    public void userLikeBrand(Long brandId, Long userId) {
        Like like = Like.builder()
                .user(userRepository.findById(userId).orElseThrow(UserNotFoundException::new))
                .brand(brandRepository.findById(brandId).orElseThrow(BrandNotFoundException::new))
                .build();

        likeRepository.save(like);
    }

    @Override
    public void userUnlikeBrand(Long brandId, Long userId) {
        likeRepository.deleteById(LikeId.builder().brandId(brandId).userId(userId).build());
    }

    @Override
    public LikeBrandListResponse getLikeBrandList(Long userId) {
        List<Like> likeList = likeRepository.findAllByUser(userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new));
        List<LikeBrandContentResponse> likeContentList = new ArrayList<>();

        for (Like like : likeList) {
            Brand brand = like.getBrand();
            likeContentList.add(
                    LikeBrandContentResponse.builder()
                            .id(brand.getId())
                            .profileUrl(brand.getProfilePath())
                            .name(brand.getName())
                            .build()
            );
        }

        return new LikeBrandListResponse(likeContentList);
    }

    @Override
    public boolean isLike(Long brandId, Long userId) {
        Optional<Like> like = likeRepository.findById(LikeId.builder()
                        .userId(userId)
                        .brandId(brandId)
                .build());

        return like.isPresent();
    }
}
