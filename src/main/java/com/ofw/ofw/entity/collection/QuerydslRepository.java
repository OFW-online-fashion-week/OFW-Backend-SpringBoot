package com.ofw.ofw.entity.collection;

import com.ofw.ofw.payload.collection.response.CollectionResponse;

public interface QuerydslRepository {

    CollectionResponse getCollection(Long collectionId);
}
