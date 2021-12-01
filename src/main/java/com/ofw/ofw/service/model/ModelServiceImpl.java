package com.ofw.ofw.service.model;

import com.ofw.ofw.entity.model.Model;
import com.ofw.ofw.entity.model.ModelRepository;
import com.ofw.ofw.entity.profile.Profile;
import com.ofw.ofw.entity.profile.ProfileRepository;
import com.ofw.ofw.exception.type.ModelNotFoundException;
import com.ofw.ofw.exception.type.ProfileNotFoundException;
import com.ofw.ofw.payload.model.request.ModelPostRequest;
import com.ofw.ofw.payload.model.response.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final ProfileRepository profileRepository;

    @Override
    public ModelSearchListResponse getSearchResults(String filter) {
        List<Model> modelList = modelRepository.findByNameStartsWithIgnoreCase(filter);
        List<ModelSearchContentResponse> modelContentList = new ArrayList<>();

        for (Model model : modelList) {
            modelContentList.add(
                    ModelSearchContentResponse.builder()
                            .id(model.getId())
                            .name(model.getName())
                            .email(model.getEmail())
                            .build()
            );
        }

        return new ModelSearchListResponse(modelContentList);
    }

    @Override
    public ModelListResponse getModelList() {
        List<Model> modelList = (List<Model>) modelRepository.findAll();
        List<ModelContentResponse> modelContentList = new ArrayList<>();

        for (Model model : modelList) {
            Profile profile = profileRepository.findByModel(model).orElseThrow(ModelNotFoundException::new);
            modelContentList.add(
                    ModelContentResponse.builder()
                            .id(model.getId())
                            .profileUrl(model.getProfilePath())
                            .name(model.getName())
                            .introduction(profile.getIntroduction())
                            .gender(profile.getGender())
                            .build()
            );
        }

        return new ModelListResponse(modelContentList);
    }

    @Override
    public ModelDetailResponse getModelDetail(Long modelId) {
        Model model = modelRepository.findById(modelId).orElseThrow(ModelNotFoundException::new);
        Profile profile = profileRepository.findByModel(model).orElseThrow(ProfileNotFoundException::new);

        return ModelDetailResponse.builder()
                .profileUrl(model.getProfilePath())
                .name(model.getName())
                .email(model.getEmail())
                .introduction(profile.getIntroduction())
                .height(profile.getHeight())
                .weight(profile.getWeight())
                .nation(profile.getNation())
                .build();
    }

    @Override
    public void postModel(ModelPostRequest request) {
        Model model = modelRepository.save(
                Model.builder()
                        .name(request.getName())
                        .email(request.getEmail())
                        .profilePath(request.getProfileUrl())
                        .build()
        );

        profileRepository.save(
                Profile.builder()
                        .model(model)
                        .height(request.getHeight())
                        .weight(request.getWeight())
                        .nation(request.getNation())
                        .gender(request.getGender())
                        .build()
        );
    }
}
