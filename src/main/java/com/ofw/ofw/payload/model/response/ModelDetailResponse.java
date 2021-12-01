package com.ofw.ofw.payload.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelDetailResponse {

    @JsonProperty("profile_url")
    private String profileUrl;

    private String name;

    private String email;

    private String introduction;

    private Long height;

    private Long weight;

    private String nation;
}
