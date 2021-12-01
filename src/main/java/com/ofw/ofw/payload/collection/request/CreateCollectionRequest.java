package com.ofw.ofw.payload.collection.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCollectionRequest {

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    @JsonProperty("designer_id")
    private Long designerId;

    @NotNull
    @JsonProperty("brand_id")
    private Long brandId;
}
