package com.ofw.ofw.payload.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ModelSearchContentResponse {

    private Long id;

    private String name;

    private String email;
}
