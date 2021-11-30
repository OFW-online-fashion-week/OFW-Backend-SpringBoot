package com.ofw.ofw.payload.designer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDesignerResponse {
    private String name;

    private String email;

    @Builder
    public SearchDesignerResponse(SearchDesignerResponse searchDesigner){
        this.name = searchDesigner.getName();
        this.email = searchDesigner.getEmail();
    }
}
