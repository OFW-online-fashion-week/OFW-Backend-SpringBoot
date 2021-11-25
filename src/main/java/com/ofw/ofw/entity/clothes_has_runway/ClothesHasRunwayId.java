package com.ofw.ofw.entity.clothes_has_runway;

import com.ofw.ofw.entity.clothes.Clothes;
import com.ofw.ofw.entity.runway.Runway;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Embeddable
public class ClothesHasRunwayId implements Serializable {
    @Column(name = "clothes_id")
    private Long clothesId;

    @Column(name = "runway_id")
    private Long runwayId;

}
