package com.ofw.ofw.entity.profile;

import com.ofw.ofw.entity.model.Model;
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
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @Column
    private Long height;

    @Column
    private Long weight;

    @Column(length = 30)
    private String nation;

    @Column(length = 1)
    private String gender;

    @Column(length = 50)
    private String introduction;
}
