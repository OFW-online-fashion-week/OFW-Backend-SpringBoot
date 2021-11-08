package com.ofw.ofw.controller;

import com.ofw.ofw.payload.response.CollectionListResponse;
import com.ofw.ofw.service.brand.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/collection")
@RestController
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    @GetMapping("/all")
    public CollectionListResponse getCollectionList(Pageable pageable) {
        return collectionService.getCollectionList(pageable);
    }
}
