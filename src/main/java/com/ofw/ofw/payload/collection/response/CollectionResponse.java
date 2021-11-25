package com.ofw.ofw.payload.collection.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CollectionResponse {
    private String title;

    private String description;

    private String designer_name;

    private String designer_description;

    private String designer_profile;

    @QueryProjection
    public CollectionResponse(String title, String description, String designer_name, String designer_description, String designer_profile) {
        this.title = title;
        this.description = description;
        this.designer_name = designer_name;
        this.designer_description = designer_description;
        this.designer_profile = designer_profile;
    }
}
