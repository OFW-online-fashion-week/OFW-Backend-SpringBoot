package com.ofw.ofw.entity.clothes;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.collection.Collection;
import com.ofw.ofw.entity.like.Like;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 250)
    private String image_path;

    @Column(length = 40)
    private String name;

    @Column( length = 25)
    private String styleCode;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column( length = 100)
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;
}
