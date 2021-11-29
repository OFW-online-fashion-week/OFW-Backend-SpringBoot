package com.ofw.ofw.payload.clothes.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClothesPostRequest {

    @NotNull
    private String name;

    @Nullable
    @JsonProperty("style_code")
    private String styleCode;

    @Nullable
    private String url;

    @Nullable
    private String description;

    @NotNull
    @JsonProperty("image_path")
    private String imagePath;
}
