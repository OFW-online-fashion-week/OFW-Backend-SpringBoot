package com.ofw.ofw.payload.auth.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class googleOauthSignUpRequest {
    private String code;
    private String name;
    private String aud;
}
