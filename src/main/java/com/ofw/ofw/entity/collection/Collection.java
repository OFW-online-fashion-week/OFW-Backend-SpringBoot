package com.ofw.ofw.entity.collection;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.collection_designer.CollectionDesigner;
import com.ofw.ofw.entity.runway.Runway;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Boolean implement = false;

    @CreatedDate
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY)
    private List<Runway> runways;

    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY)
    private List<CollectionDesigner> collection_designer;
}
