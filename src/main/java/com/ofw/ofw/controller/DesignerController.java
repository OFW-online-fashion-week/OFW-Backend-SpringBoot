package com.ofw.ofw.controller;

import com.ofw.ofw.payload.designer.request.CreateDesignerRequest;
import com.ofw.ofw.payload.designer.request.SearchDesignerRequest;
import com.ofw.ofw.payload.designer.response.CollectionDesignerResponse;
import com.ofw.ofw.payload.designer.response.SerachDesignerResponse;
import com.ofw.ofw.service.designer.DesignerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/designer")
@RestController
@RequiredArgsConstructor
public class DesignerController {

    private final DesignerService designerService;

    @GetMapping("/search")
    public SerachDesignerResponse searchDesigner(@RequestBody SearchDesignerRequest request) {
        return designerService.searchDesigner(request);
    }

    @GetMapping("/{collectionId}")
    public CollectionDesignerResponse getDesigner(@PathVariable Long collectionId){
        return designerService.getDesigner(collectionId);
    }

    @PostMapping()
    public void createDesigner(@RequestBody CreateDesignerRequest request){
        designerService.createDesigner(request);
    }
}
