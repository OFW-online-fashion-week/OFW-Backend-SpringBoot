package com.ofw.ofw.payload.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminBrandListResponse {

    private List<AdminBrandContentResponse> adminBrandContentResponseList;
}
