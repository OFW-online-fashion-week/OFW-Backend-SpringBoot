package com.ofw.ofw.entity.like;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.runway.Runway;
import com.ofw.ofw.entity.user.User;
import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@QueryEntity
public class Like {
    @EmbeddedId
    @Builder.Default
    private LikeId likeId = new LikeId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("brandId")
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

}
