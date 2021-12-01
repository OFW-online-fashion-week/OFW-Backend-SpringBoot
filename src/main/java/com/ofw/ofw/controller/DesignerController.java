package com.ofw.ofw.controller;

import com.ofw.ofw.payload.designer.request.CreateDesignerRequest;
import com.ofw.ofw.payload.designer.response.CollectionDesignerResponse;
import com.ofw.ofw.payload.designer.response.SearchDesignerResponse;
import com.ofw.ofw.payload.designer.response.SearchDesignerResponseList;
import com.ofw.ofw.service.designer.DesignerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/designer")
@RestController
@RequiredArgsConstructor
public class DesignerController {

    private final DesignerService designerService;

    @PostMapping
    public String createDesigner(@RequestBody CreateDesignerRequest request){
        designerService.createDesigner(request);
        return "success";
    }

    @GetMapping("/search/{name}")
    public SearchDesignerResponseList searchDesigner(@PathVariable String name) {
        return designerService.searchDesigner(name);
    }

    @GetMapping("/{collectionId}")
    public CollectionDesignerResponse getDesigner(@PathVariable Long collectionId){
        return designerService.getDesigner(collectionId);
    }

}
