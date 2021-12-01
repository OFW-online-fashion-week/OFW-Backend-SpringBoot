package com.ofw.ofw.payload.runway.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RunwayPostRequest {

    @NotNull
    @JsonProperty("collection_id")
    private Long collectionId;

    @NotNull
    @JsonProperty("model_id")
    private Long modelId;

    @NotNull
    @JsonProperty("runway_url")
    private String runwayUrl;

    @NotNull
    @JsonProperty("clothes_id")
    private List<Long> clothesId;

    @Nullable
    @JsonProperty("bgm_url")
    private String bgmUrl;
}
