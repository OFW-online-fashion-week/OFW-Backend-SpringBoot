package com.ofw.ofw.entity.runway;

import com.ofw.ofw.entity.collection.Collection;
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
public class Runway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_id")
    private Collection collection;

    //model fk 하기

    @Column(nullable = false, length = 250)
    private String runwayPath;

    @Column(length = 250)
    private String bgmPath;

    @Column
    private Long accessCount;
}
