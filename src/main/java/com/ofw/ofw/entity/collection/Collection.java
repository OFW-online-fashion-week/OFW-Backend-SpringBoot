package com.ofw.ofw.entity.collection;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.collection_designer.Collection_designer;
import com.ofw.ofw.entity.runway.Runway;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(nullable = false, length = 50)
    private String title;

    private String description;

    @Column(nullable = false)
    private Boolean implement;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Runway> runways;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Collection_designer> collection_designer;
}
