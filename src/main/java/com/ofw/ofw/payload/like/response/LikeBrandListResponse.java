package com.ofw.ofw.payload.like.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LikeBrandListResponse {

    List<LikeBrandContentResponse> likeBrandContentResponseList;
}
