package com.ofw.ofw.payload.designer.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDesignerRequest {
    @NotNull
    String name;
}
