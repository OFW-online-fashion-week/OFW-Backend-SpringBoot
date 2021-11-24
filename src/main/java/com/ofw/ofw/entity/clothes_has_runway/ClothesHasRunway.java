package com.ofw.ofw.entity.clothes_has_runway;

import com.ofw.ofw.entity.clothes.Clothes;
import com.ofw.ofw.entity.runway.Runway;
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
public class ClothesHasRunway {
    @Id
    private Long clothes_id;

    @Id
    private Long runway_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("clothes_id")
    @JoinColumn(name = "clothes_id")
    private Clothes clothes;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("runway_id")
    @JoinColumn(name = "runway_id")
    private Runway runway;
}
