package com.ofw.ofw.payload.designer.response;

import com.querydsl.core.annotations.QueryProjection;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CollectionDesignerResponse {
    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String profilePath;
}
