package com.ofw.ofw.payload.collection.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CollectionResponse {
    private String title;

    private String description;

    private String designerName;

    private String designerEmail;

    private String designerDescription;

    private String designerProfile;

}
