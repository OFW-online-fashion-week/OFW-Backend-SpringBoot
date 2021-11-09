package com.ofw.ofw.payload.auth.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthRequestBrandRegisteringRequest {

    @NotNull
    private String profileUrl;

    @NotNull
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