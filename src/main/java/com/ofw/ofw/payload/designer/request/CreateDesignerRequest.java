package com.ofw.ofw.payload.designer.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDesignerRequest {
    @NotNull
    String email;

    @NotNull
    String name;

    @NotNull
    @JsonProperty("profile_path")
    String profilePath;

    String description;
}
