package com.ofw.ofw.payload.clothes.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClothesSearchContentResponse {

    private String name;

    @JsonProperty("style_code")
    private String styleCode;
}
