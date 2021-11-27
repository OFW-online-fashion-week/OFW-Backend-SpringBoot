package com.ofw.ofw.service.designer;

import com.ofw.ofw.entity.designer.Designer;
import com.ofw.ofw.entity.designer.DesignerRepository;
import com.ofw.ofw.payload.designer.request.SearchDesignerRequest;
import com.ofw.ofw.payload.designer.response.SerachDesignerResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DesignerServiceImpl implements DesignerService{
    private final DesignerRepository designerRepository;

    @Override
    public SerachDesignerResponse searchDesigner(SearchDesignerRequest request){
        SerachDesignerResponse designer = designerRepository.findByNameIsLike(request.getName());

        return new SerachDesignerResponse(designer);
    }

}
