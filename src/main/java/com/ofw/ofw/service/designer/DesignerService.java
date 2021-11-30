package com.ofw.ofw.service.designer;

import com.ofw.ofw.payload.designer.request.CreateDesignerRequest;
import com.ofw.ofw.payload.designer.response.CollectionDesignerResponse;
import com.ofw.ofw.payload.designer.response.SearchDesignerResponse;

public interface DesignerService {
    SearchDesignerResponse searchDesigner(String name);
    CollectionDesignerResponse getDesigner(Long collectionId);
    void createDesigner(CreateDesignerRequest request);
}
