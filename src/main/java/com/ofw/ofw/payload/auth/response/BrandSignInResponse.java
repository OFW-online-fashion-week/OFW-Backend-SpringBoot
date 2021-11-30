package com.ofw.ofw.payload.auth.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BrandSignInResponse {
    private final String accessToken;
    private final String id;
    private final String aud;
}
