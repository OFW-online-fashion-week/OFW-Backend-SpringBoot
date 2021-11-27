package com.ofw.ofw.payload.auth.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
public class TokenResponse {

    private final String accessToken;
}

