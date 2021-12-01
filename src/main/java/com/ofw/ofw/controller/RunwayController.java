package com.ofw.ofw.controller;

import com.ofw.ofw.payload.runway.request.RunwayPostRequest;
import com.ofw.ofw.payload.runway.response.RunwayDetailResponse;
import com.ofw.ofw.payload.runway.response.RunwayListResponse;
import com.ofw.ofw.service.runway.RunwayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/runway")
public class RunwayController {

    private final RunwayService runwayService;

    @PostMapping
    public String postRunway(@RequestBody RunwayPostRequest request) {
        runwayService.postRunway(request);
        return "access";
    }

    @DeleteMapping
    public String deleteRunway(@RequestParam Long runwayId) {
        runwayService.deleteRunway(runwayId);
        return "success";
    }

    @GetMapping("/brand")
    public RunwayListResponse getRunways(@RequestParam Long collectionId) {
        return runwayService.getRunwayList(collectionId);
    }

    @GetMapping
    public RunwayDetailResponse getRunway(@RequestParam Long runwayId) {
        return runwayService.getRunwayDetail(runwayId);
    }
}
