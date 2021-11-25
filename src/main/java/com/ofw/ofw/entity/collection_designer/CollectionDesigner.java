package com.ofw.ofw.entity.collection_designer;

import com.ofw.ofw.entity.collection.Collection;
import com.ofw.ofw.entity.designer.Designer;
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
public class CollectionDesigner {
    @EmbeddedId
    @Builder.Default
    private CollectionDesignerId designerId = new CollectionDesignerId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("collection_id")
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("designer_id")
    @JoinColumn(name = "designer_id")
    private Designer designer;
}