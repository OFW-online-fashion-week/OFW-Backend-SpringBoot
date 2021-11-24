package com.ofw.ofw.entity.profile;

import com.ofw.ofw.entity.model.Model;
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
public class Profile {
    @Id
    private Long model_id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId("model_id")
    @JoinColumn(name = "model_id")
    private Model model;

    @Column
    private Long height;

    @Column
    private Long weight;

    @Column
    private Long nation;
}
