package com.ofw.ofw.service.designer;

import com.ofw.ofw.entity.collection.CollectionRepository;
import com.ofw.ofw.entity.designer.Designer;
import com.ofw.ofw.entity.designer.DesignerRepository;
import com.ofw.ofw.exception.type.CollectionNotFoundException;
import com.ofw.ofw.payload.designer.request.CreateDesignerRequest;
import com.ofw.ofw.payload.designer.response.CollectionDesignerResponse;
import com.ofw.ofw.payload.designer.response.SearchDesignerResponse;
import com.ofw.ofw.payload.designer.response.SearchDesignerResponseList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DesignerServiceImpl implements DesignerService{
    private final DesignerRepository designerRepository;
    private final CollectionRepository collectionRepository;


    @Override
    public SearchDesignerResponseList searchDesigner(String name){
        List<Designer> designers = designerRepository.findByNameContaining(name);

        List<SearchDesignerResponse> designerResponses =
                designers.stream().map(
                        designer -> SearchDesignerResponse.builder()
                                .id(designer.getId().toString())
                                .name(designer.getName())
                                .email(designer.getEmail())
                                .build()
                ).collect(Collectors.toList());

        return new SearchDesignerResponseList(designerResponses);
    }

    @Override
    public CollectionDesignerResponse getDesigner(Long collectionId){
        Designer designer = collectionRepository.findById(collectionId)
                .orElseThrow(CollectionNotFoundException::new)
                .getCollection_designer().get(0)
                .getDesigner();

        return new CollectionDesignerResponse(
                designer.getEmail(),
                designer.getName(),
                designer.getDescription(),
                designer.getProfilePath()
        );
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
