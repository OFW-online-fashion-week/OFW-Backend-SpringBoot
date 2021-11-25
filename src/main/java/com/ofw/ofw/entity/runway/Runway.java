package com.ofw.ofw.entity.runway;

import com.ofw.ofw.entity.collection.Collection;
import com.ofw.ofw.entity.history.History;
import com.ofw.ofw.entity.model.Model;
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
public class Runway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 250)
    private String runway_path;

    @Column(length = 250)
    private String bgm_path;

    @Column
    private Long accessCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private Model model;

    @OneToMany(mappedBy = "runway", fetch = FetchType.LAZY)
    private List<History> history;
}
