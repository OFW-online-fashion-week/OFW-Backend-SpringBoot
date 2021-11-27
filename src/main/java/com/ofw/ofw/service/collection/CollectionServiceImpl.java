package com.ofw.ofw.service.collection;

import com.ofw.ofw.entity.auth.AuthBrandCache;
import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.collection.Collection;
import com.ofw.ofw.entity.collection.CollectionRepository;
import com.ofw.ofw.entity.collection_designer.CollectionDesigner;
import com.ofw.ofw.entity.collection_designer.CollectionDesignerRepository;
import com.ofw.ofw.entity.designer.Designer;
import com.ofw.ofw.entity.designer.DesignerRepository;
import com.ofw.ofw.exception.type.DesignerNotFoundException;
import com.ofw.ofw.payload.collection.request.CreateCollectionRequest;
import com.ofw.ofw.payload.collection.response.BrandCollectionListResponse;
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
    private final DesignerRepository designerRepository;
    private final CollectionDesignerRepository collectionDesignerRepository;

    @Override
    public CollectionListResponse getCollectionList(Pageable pageable) {
        List<Collection> collections = collectionRepository.findAllByOrderByCreatedAt(pageable)
                .getContent();
        List<CollectionContentResponse> contentResponses =
                collections.stream().map(
                                collection -> CollectionContentResponse.builder()
                                        .description(collection.getDescription())
                                        .title(collection.getTitle())
                                        .runwayPath(collection.getRunways().isEmpty() ? collection.getRunways().get(0).getRunwayPath() : null)
                                        .build())
                        .collect(Collectors.toList());
        return new CollectionListResponse(contentResponses);
    }

    @Override
    public CollectionResponse getCollection(Long collectionId) {
        CollectionResponse collection = collectionRepository.getCollection(collectionId);

        return collection;
    }

    @Override
    public void createCollection(CreateCollectionRequest request) {
        Designer designer = designerRepository.findById(request.getDesignerId())
                .orElseThrow(DesignerNotFoundException::new);

        Collection collection = Collection.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .brand(Brand.builder().id(request.getBrandId()).build())
                .implement(false)
                .build();
        collectionRepository.save(collection);

        CollectionDesigner collectionDesigner = CollectionDesigner.builder()
                .collection(collection)
                .designer(designer)
                .build();
        collectionDesignerRepository.save(collectionDesigner);
    }

    @Override
    public BrandCollectionListResponse getBrandCollectionList(Long brandId){
        List<Collection> brandCollections = collectionRepository.findAllByBrand(brandId);

        List<CollectionContentResponse> brandContentResponses =
                brandCollections.stream().map(
                                collection -> CollectionContentResponse.builder()
                                        .description(collection.getDescription())
                                        .title(collection.getTitle())
                                        .runwayPath(collection.getRunways().isEmpty() ? collection.getRunways().get(0).getRunwayPath() : null)
                                        .build())
                        .collect(Collectors.toList());
        return new BrandCollectionListResponse(brandContentResponses);
    }
}
