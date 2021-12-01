package com.ofw.ofw.payload.runway.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RunwayContentResponse {

    private Long id;

    @JsonProperty("runway_url")
    private String runwayUrl;

    private Integer count;
}
