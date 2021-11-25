package com.ofw.ofw.service.collection;

import com.ofw.ofw.payload.collection.response.CollectionListResponse;
import com.ofw.ofw.payload.collection.response.CollectionResponse;
import org.springframework.data.domain.Pageable;

public interface CollectionService {
    CollectionListResponse getCollectionList(Pageable pageable);
    CollectionResponse getCollection(Long collection_id);
}
