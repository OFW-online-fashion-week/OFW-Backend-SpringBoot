package com.ofw.ofw.payload.designer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SerachDesignerResponse {
    private String name;

    private String email;

    public SerachDesignerResponse(SerachDesignerResponse searchDesigner){
        this.name = searchDesigner.getName();
        this.email = searchDesigner.getEmail();
    }
}
