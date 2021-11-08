package com.ofw.ofw.service.brand;

import com.ofw.ofw.payload.response.CollectionListResponse;
import org.springframework.data.domain.Pageable;

public interface CollectionService {
    CollectionListResponse getCollectionList(Pageable pageable);
}
