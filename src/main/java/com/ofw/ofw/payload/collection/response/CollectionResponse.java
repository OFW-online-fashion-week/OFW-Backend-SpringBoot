package com.ofw.ofw.payload.collection.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CollectionResponse {
    private String title;

    private String description;

    private String designerName;

    private String designerDescription;

    private String designerProfile;

    @QueryProjection
    public CollectionResponse(String title, String description, String designerName, String designerDescription, String designerProfile) {
        this.title = title;
        this.description = description;
        this.designerName = designerName;
        this.designerDescription = designerDescription;
        this.designerProfile = designerProfile;
    }

    public CollectionResponse(CollectionResponse collection){
        this.title = collection.getTitle();
        this.description = collection.getDescription();
        this.designerName = collection.getDesignerName();
        this.designerDescription = collection.getDesignerDescription();
        this.designerProfile = collection.getDesignerProfile();
    }
}
