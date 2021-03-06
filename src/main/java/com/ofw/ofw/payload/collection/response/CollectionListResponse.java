package com.ofw.ofw.payload.collection.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CollectionListResponse {
    private List<CollectionContentResponse> collectionContentResponses;
}
