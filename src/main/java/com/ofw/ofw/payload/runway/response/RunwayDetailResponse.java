package com.ofw.ofw.payload.runway.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RunwayDetailResponse {

    private Long id;

    @JsonProperty("runway_url")
    private String runwayUrl;

    private String bgmPath;

    private List<Long> clothes;
}
