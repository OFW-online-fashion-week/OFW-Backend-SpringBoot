package com.ofw.ofw.payload.auth.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class googleOauthLogInRequest {
    private String code;
    private String aud;
}
