package com.ofw.ofw.service.model;

import com.ofw.ofw.payload.model.request.ModelPostRequest;
import com.ofw.ofw.payload.model.response.ModelDetailResponse;
import com.ofw.ofw.payload.model.response.ModelListResponse;
import com.ofw.ofw.payload.model.response.ModelSearchListResponse;

public interface ModelService {

    ModelSearchListResponse getSearchResults(String filter);

    ModelListResponse getModelList();

    ModelDetailResponse getModelDetail(Long modelId);

    void postModel(ModelPostRequest request);
}
