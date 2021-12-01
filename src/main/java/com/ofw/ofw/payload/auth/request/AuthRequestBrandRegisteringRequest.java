package com.ofw.ofw.payload.auth.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class  AuthRequestBrandRegisteringRequest {

    @NotNull
    @JsonProperty("profile_url")
    private String profileUrl;

    @NotNull
    @JsonProperty("cover_url")
    private String coverUrl;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String url;

    @Nullable
    private String description;
}