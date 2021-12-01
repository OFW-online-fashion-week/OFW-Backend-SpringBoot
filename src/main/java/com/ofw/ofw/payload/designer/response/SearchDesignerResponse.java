package com.ofw.ofw.payload.designer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SearchDesignerResponse {
    private String id;

    private String name;

    private String email;

    public SearchDesignerResponse(SearchDesignerResponse searchDesigner){
        this.id = searchDesigner.getId();
        this.name = searchDesigner.getName();
        this.email = searchDesigner.getEmail();
    }
}
