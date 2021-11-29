package com.ofw.ofw.payload.like.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeBrandContentResponse {

    private Long id;

    @JsonProperty("profile_url")
    private String profileUrl;

    private String name;
}
