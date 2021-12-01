package com.ofw.ofw.payload.runway.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RunwayListResponse {

    private List<RunwayContentResponse> runwayContentResponseList;
}
