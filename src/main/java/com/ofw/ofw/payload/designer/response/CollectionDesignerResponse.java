package com.ofw.ofw.payload.designer.response;

import com.querydsl.core.annotations.QueryProjection;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class CollectionDesignerResponse {
    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @NotNull
    private String profilePath;

    @QueryProjection
    public CollectionDesignerResponse(String email, String name, String description, String profilePath) {
        this.email = email;
        this.name = name;
        this.description = description;
        this.profilePath = profilePath;
    }

    public CollectionDesignerResponse(CollectionDesignerResponse designerResponse){
        this.email = designerResponse.getEmail();
        this.name = designerResponse.getName();
        this.description = designerResponse.getDescription();
        this.profilePath = designerResponse.getProfilePath();
    }
}
