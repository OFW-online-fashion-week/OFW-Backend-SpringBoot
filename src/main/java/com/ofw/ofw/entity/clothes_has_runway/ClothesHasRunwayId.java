package com.ofw.ofw.entity.clothes_has_runway;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ClothesHasRunwayId implements Serializable {
    @Column(name = "clothes_id")
    private Long clothesId;

    @Column(name = "runway_id")
    private Long runwayId;

}
