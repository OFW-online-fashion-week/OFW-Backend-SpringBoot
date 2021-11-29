package com.ofw.ofw.service.like;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.like.Like;
import com.ofw.ofw.entity.like.LikeId;
import com.ofw.ofw.entity.like.LikeRepository;
import com.ofw.ofw.entity.user.UserRepository;
import com.ofw.ofw.exception.type.UserNotFoundException;
import com.ofw.ofw.payload.like.response.LikeBrandContentResponse;
import com.ofw.ofw.payload.like.response.LikeBrandListResponse;
import com.ofw.ofw.security.jwt.auth.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likeRepository;
    private final AuthenticationFacade authenticationFacade;
    private final UserRepository userRepository;

    @Override
    public void userLikeBrand(Long brandId) {
        Like like = Like.builder()
                .likeId(LikeId.builder().brandId(brandId).userId(authenticationFacade.getUserId()).build())
                .build();

        likeRepository.save(like);
    }

    @Override
    public void userUnlikeBrand(Long brandId) {
        likeRepository.deleteById(LikeId.builder().brandId(brandId).userId(authenticationFacade.getUserId()).build());
    }

    @Override
    public LikeBrandListResponse getLikeBrandList() {
        List<Like> likeList = likeRepository.findAllByUser(userRepository.findById(authenticationFacade.getUserId())
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
}
