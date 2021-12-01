package com.ofw.ofw.payload.brand.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BrandContentResponse {

    private Long id;

    private String name;
}
