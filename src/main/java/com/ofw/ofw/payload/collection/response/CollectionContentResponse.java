package com.ofw.ofw.payload.collection.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CollectionContentResponse {

    private Long id;

    private String title;

    private String runwayPath;

    private String description;

}
