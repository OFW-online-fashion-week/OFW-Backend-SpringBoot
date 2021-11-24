package com.ofw.ofw.entity.model;

import com.ofw.ofw.entity.brand.Brand;
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
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String email;

    @Column(nullable = false, length = 250)
    private String profile_path;

    @Column(nullable = false, length = 30)
    private String nation;

    @Column(length = 50)
    private String introduction;
}