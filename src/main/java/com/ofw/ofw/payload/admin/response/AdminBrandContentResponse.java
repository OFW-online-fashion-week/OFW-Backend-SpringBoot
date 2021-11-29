package com.ofw.ofw.payload.admin.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class AdminBrandContentResponse {

    private String id;

    @JsonProperty("profile_url")
    private String profileUrl;

    private String name;

    @JsonProperty("created_at")
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime createdAt;
}
