package com.ofw.ofw.payload.auth.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignInBrandRequest {
    @NotNull
    String email;

    @NotNull
    String password;
}
