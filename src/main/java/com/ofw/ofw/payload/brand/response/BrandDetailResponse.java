package com.ofw.ofw.payload.brand.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandDetailResponse {

    private Long id;

    private String name;

    private String email;

    @JsonProperty("profile_url")
    private String profileUrl;

    @JsonProperty("cover_url")
    private String coverUrl;

    private String description;

    private String url;

    @JsonProperty("is_like")
    private boolean isLike = false;
}
