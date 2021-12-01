package com.ofw.ofw.payload.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModelSearchListResponse {

    List<ModelSearchContentResponse> modelSearchContentResponseList;
}
