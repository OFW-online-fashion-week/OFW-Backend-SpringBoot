package com.ofw.ofw.entity.collection_designer;

import com.ofw.ofw.entity.collection.Collection;
import com.ofw.ofw.entity.designer.Designer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Embeddable
public class CollectionDesignerId implements Serializable {
    @Column(name = "collection_id")
    private Long collectionId;

    @Column(name = "designerId_id")
    private Long designerId;

}