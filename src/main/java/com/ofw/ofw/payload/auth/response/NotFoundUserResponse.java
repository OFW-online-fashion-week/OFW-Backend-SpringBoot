package com.ofw.ofw.payload.auth.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class NotFoundUserResponse {
    private final Boolean isFresh;
    private final String email;
}
