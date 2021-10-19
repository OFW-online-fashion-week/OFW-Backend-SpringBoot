package com.ofw.ofw.payload.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BrandSignupRequest {

    @NotNull
    private String profileFile;

    @NotNull
    private String coverFile;

    @NotNull
    private String url;

    @NotNull
    private String description;
}
