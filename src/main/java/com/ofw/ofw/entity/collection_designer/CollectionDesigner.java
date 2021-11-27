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
    private CollectionDesignerId collectionDesignerId = new CollectionDesignerId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("collectionId")
    @JoinColumn(name = "collection_id")
    private Collection collection;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("designerId")
    @JoinColumn(name = "designer_id")
    private Designer designer;
}