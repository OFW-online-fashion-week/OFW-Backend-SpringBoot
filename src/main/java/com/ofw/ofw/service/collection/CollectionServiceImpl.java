package com.ofw.ofw.service.collection;

import com.ofw.ofw.entity.collection.Collection;
import com.ofw.ofw.entity.collection.CollectionRepository;
import com.ofw.ofw.payload.collection.response.CollectionContentResponse;
import com.ofw.ofw.payload.collection.response.CollectionListResponse;
import com.ofw.ofw.payload.collection.response.CollectionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;

    @Override
    public CollectionListResponse getCollectionList(Pageable pageable) {
        List<Collection> collections = collectionRepository.findAllByOrderByCreatedAt(pageable)
                .getContent();
        List<CollectionContentResponse> contentResponses =
                collections.stream().map(
                        collection -> CollectionContentResponse.builder()
                                .description(collection.getDescription())
                                .title(collection.getTitle())
                                .runway_path(collection.getRunways().isEmpty() ? collection.getRunways().get(0).getRunway_path() : null)
                                .build())
                        .collect(Collectors.toList());
        return new CollectionListResponse(contentResponses);
    }

    @Override
    public CollectionResponse getCollection(Long collectionId){
        CollectionResponse collection = collectionRepository.getCollection(collectionId);

        return collection;
        }
}
