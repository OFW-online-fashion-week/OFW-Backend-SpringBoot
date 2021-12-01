package com.ofw.ofw.payload.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ModelPostRequest {

    @NotNull
    private String name;

    @NotNull
    private String email;

    @Nullable
    private String introduction;

    @Nullable
    private Long height;

    @Nullable
    private Long weight;

    @Nullable
    private String nation;

    @NotNull
    private String gender;

    @NotNull
    @JsonProperty("profile_url")
    private String profileUrl;
}
