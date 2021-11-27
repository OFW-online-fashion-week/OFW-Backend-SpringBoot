package com.ofw.ofw.payload.designer.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateDesignerRequest {
    @NotNull
    String email;

    @NotNull
    String name;

    @NotNull
    String profilePath;

    String description;
}
