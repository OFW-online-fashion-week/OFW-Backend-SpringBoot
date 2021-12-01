package com.ofw.ofw.entity.like;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LikeId implements Serializable {
    @Column(name = "brand_id")
    private Long brandId;

    @Column(name = "user_id")
    private Long userId;

}
