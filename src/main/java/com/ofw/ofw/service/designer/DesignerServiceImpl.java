package com.ofw.ofw.service.designer;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.collection.Collection;
import com.ofw.ofw.entity.collection.CollectionRepository;
import com.ofw.ofw.entity.collection_designer.CollectionDesignerRepository;
import com.ofw.ofw.entity.designer.Designer;
import com.ofw.ofw.entity.designer.DesignerRepository;
import com.ofw.ofw.exception.type.DesignerNotFoundException;
import com.ofw.ofw.payload.designer.request.CreateDesignerRequest;
import com.ofw.ofw.payload.designer.request.SearchDesignerRequest;
import com.ofw.ofw.payload.designer.response.CollectionDesignerResponse;
import com.ofw.ofw.payload.designer.response.SerachDesignerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DesignerServiceImpl implements DesignerService{
    private final DesignerRepository designerRepository;
    private final CollectionRepository collectionRepository;


    @Override
    public SerachDesignerResponse searchDesigner(SearchDesignerRequest request){
        SerachDesignerResponse designer = designerRepository.findByName(request.getName());

        return new SerachDesignerResponse(designer);
    }

    @Override
    public CollectionDesignerResponse getDesigner(Long collectionId){
        CollectionDesignerResponse designer = collectionRepository.getCollectionDesigner(collectionId);

        return new CollectionDesignerResponse(designer);
    }

    @Override
    public void createDesigner(CreateDesignerRequest request) {
        Designer designer = Designer.builder()
                .email(request.getEmail())
                .name(request.getName())
                .profilePath(request.getProfilePath())
                .description(request.getDescription())
                .build();
        designerRepository.save(designer);
    }

}
