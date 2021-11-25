package com.ofw.ofw.entity.designer;

import com.ofw.ofw.entity.collection_designer.CollectionDesigner;
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
public class Designer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String email;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, length = 250)
    private String profile_path;

    @OneToMany(mappedBy = "designer", fetch = FetchType.LAZY)
    private List<CollectionDesigner> collection_designer;
}
