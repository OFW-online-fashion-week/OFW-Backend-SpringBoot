package com.ofw.ofw.entity.like;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@Embeddable
public class LikeId implements Serializable {
    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "user_id")
    private Long userId;

}
