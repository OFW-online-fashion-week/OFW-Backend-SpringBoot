package com.ofw.ofw.service.collection;

import com.ofw.ofw.payload.collection.response.CollectionListResponse;
import org.springframework.data.domain.Pageable;

public interface CollectionService {
    CollectionListResponse getCollectionList(Pageable pageable);
}
