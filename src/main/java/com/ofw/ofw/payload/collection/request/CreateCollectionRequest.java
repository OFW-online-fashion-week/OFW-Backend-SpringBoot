package com.ofw.ofw.payload.collection.request;

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
    private Long designerId;

    @NotNull
    private Long brandId;
}
