package com.ofw.ofw.payload.auth.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GoogleOauthSignUpRequest {
    private String email;
    private String name;
    private String aud;
}
