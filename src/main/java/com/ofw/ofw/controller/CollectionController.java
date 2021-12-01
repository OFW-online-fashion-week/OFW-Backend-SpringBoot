package com.ofw.ofw.controller;

import com.ofw.ofw.payload.collection.request.CreateCollectionRequest;
import com.ofw.ofw.payload.collection.response.BrandCollectionListResponse;
import com.ofw.ofw.payload.collection.response.CollectionListResponse;
import com.ofw.ofw.payload.collection.response.CollectionResponse;
import com.ofw.ofw.service.collection.CollectionService;
import com.ofw.ofw.service.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/collection")
@RestController
@RequiredArgsConstructor
public class CollectionController {

    private final CollectionService collectionService;

    @GetMapping("/all")
    public CollectionListResponse getCollectionList(Pageable pageable) {
        return collectionService.getCollectionList(pageable);
    }

    @GetMapping("/{collectionId}")
    public CollectionResponse getCollection(@PathVariable Long collectionId){
        return collectionService.getCollection(collectionId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String createCollection(@RequestBody CreateCollectionRequest request){
        collectionService.createCollection(request);
        return "success";
    }

    @PostMapping("/submit")
    public String collectionSubmit(@RequestParam("collection_id") Long collectionId) {
        collectionService.submitCollection(collectionId);
        return "success";
    }

    @GetMapping("/brand/{brandId}")
    public BrandCollectionListResponse getBrandCollectionList(@PathVariable Long brandId){
        return collectionService.getBrandCollectionList(brandId);
    }

}
