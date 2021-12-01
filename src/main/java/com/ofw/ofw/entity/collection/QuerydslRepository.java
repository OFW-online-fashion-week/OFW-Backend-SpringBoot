package com.ofw.ofw.entity.collection;

import com.ofw.ofw.payload.collection.response.CollectionResponse;
import com.ofw.ofw.payload.designer.response.CollectionDesignerResponse;

public interface QuerydslRepository {

    CollectionResponse getCollection(Long collectionId);
    CollectionDesignerResponse getCollectionDesigner(Long collectionId);
}
