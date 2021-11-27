package com.ofw.ofw.service.designer;

import com.ofw.ofw.payload.designer.request.CreateDesignerRequest;
import com.ofw.ofw.payload.designer.request.SearchDesignerRequest;
import com.ofw.ofw.payload.designer.response.CollectionDesignerResponse;
import com.ofw.ofw.payload.designer.response.SerachDesignerResponse;

public interface DesignerService {
    SerachDesignerResponse searchDesigner(SearchDesignerRequest request);
    CollectionDesignerResponse getDesigner(Long collectionId);
    void createDesigner(CreateDesignerRequest request);
}
