package com.ofw.ofw.service.collection;

import com.ofw.ofw.payload.collection.request.CreateCollectionRequest;
import com.ofw.ofw.payload.collection.response.BrandCollectionListResponse;
import com.ofw.ofw.payload.collection.response.CollectionListResponse;
import com.ofw.ofw.payload.collection.response.CollectionResponse;
import org.springframework.data.domain.Pageable;

public interface CollectionService {
    CollectionListResponse getCollectionList(Pageable pageable);
    CollectionResponse getCollection(Long collectionId);
    void createCollection(CreateCollectionRequest request);
    BrandCollectionListResponse getBrandCollectionList(Long brandId);
}
