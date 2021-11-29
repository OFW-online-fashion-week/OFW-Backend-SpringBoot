package com.ofw.ofw.service.runway;

import com.ofw.ofw.payload.runway.request.RunwayPostRequest;
import com.ofw.ofw.payload.runway.response.RunwayDetailResponse;
import com.ofw.ofw.payload.runway.response.RunwayListResponse;

public interface RunwayService {

    void postRunway(RunwayPostRequest request);

    void deleteRunway(Long runwayId);

    RunwayListResponse getRunwayList(Long collectionId);

    RunwayDetailResponse getRunwayDetail(Long runwayId);
}
