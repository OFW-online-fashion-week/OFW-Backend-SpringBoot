package com.ofw.ofw.service.designer;

import com.ofw.ofw.payload.designer.request.CreateDesignerRequest;
import com.ofw.ofw.payload.designer.response.CollectionDesignerResponse;
import com.ofw.ofw.payload.designer.response.SearchDesignerResponse;
import com.ofw.ofw.payload.designer.response.SearchDesignerResponseList;

public interface DesignerService {
    SearchDesignerResponseList searchDesigner(String name);
    CollectionDesignerResponse getDesigner(Long collectionId);
    void createDesigner(CreateDesignerRequest request);
}
