package com.ofw.ofw.controller;

import com.ofw.ofw.payload.model.request.ModelPostRequest;
import com.ofw.ofw.payload.model.response.ModelDetailResponse;
import com.ofw.ofw.payload.model.response.ModelListResponse;
import com.ofw.ofw.payload.model.response.ModelSearchListResponse;
import com.ofw.ofw.service.model.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/model")
public class ModelController {
    private final ModelService modelService;

    @GetMapping("/search")
    public ModelSearchListResponse getSearchModels(@RequestParam String filter) {
        return modelService.getSearchResults(filter);
    }

    @GetMapping
    public ModelListResponse getModels() {
        return modelService.getModelList();
    }

    @GetMapping("/{model_id}")
    public ModelDetailResponse getModel(@PathVariable("model_id") Long modelId) {
        return modelService.getModelDetail(modelId);
    }

    @PostMapping
    public String createModel(@RequestBody ModelPostRequest request) {
        modelService.postModel(request);
        return "success";
    }
}
