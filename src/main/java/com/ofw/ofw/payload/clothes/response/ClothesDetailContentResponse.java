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
public class ClothesDetailContentResponse {

        private String name;

        @JsonProperty("style_code")
        private String styleCode;

        private String url;

        private String description;

        @JsonProperty("image_path")
        private String imagePath;
}
