package com.ofw.ofw.service.runway;

import com.ofw.ofw.entity.clothes.ClothesRepository;
import com.ofw.ofw.entity.clothes_has_runway.ClothesHasRunway;
import com.ofw.ofw.entity.clothes_has_runway.ClothesHasRunwayId;
import com.ofw.ofw.entity.clothes_has_runway.ClothesHasRunwayRepository;
import com.ofw.ofw.entity.collection.CollectionRepository;
import com.ofw.ofw.entity.history.History;
import com.ofw.ofw.entity.history.HistoryRepository;
import com.ofw.ofw.entity.model.ModelRepository;
import com.ofw.ofw.entity.runway.Runway;
import com.ofw.ofw.entity.runway.RunwayRepository;
import com.ofw.ofw.entity.user.UserRepository;
import com.ofw.ofw.exception.type.*;
import com.ofw.ofw.payload.runway.request.RunwayPostRequest;
import com.ofw.ofw.payload.runway.response.RunwayContentResponse;
import com.ofw.ofw.payload.runway.response.RunwayDetailResponse;
import com.ofw.ofw.payload.runway.response.RunwayListResponse;
import com.ofw.ofw.security.jwt.auth.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RunwayServiceImpl implements RunwayService {

    private final RunwayRepository runwayRepository;
    private final CollectionRepository collectionRepository;
    private final ModelRepository modelRepository;
    private final ClothesHasRunwayRepository clothesHasRunwayRepository;
    private final HistoryRepository historyRepository;
    private final UserRepository userRepository;
    private final AuthenticationFacade authenticationFacade;
    private final ClothesRepository clothesRepository;

    @Override
    public void postRunway(RunwayPostRequest request) {
        Runway runway = Runway.builder()
                .runwayPath(request.getRunwayUrl())
                .bgmPath(request.getRunwayUrl())
                .collection(collectionRepository.findById(request.getCollectionId())
                        .orElseThrow(RunwayNotFoundException::new))
                .model(modelRepository.findById(request.getModelId()).orElseThrow(ModelNotFoundException::new))
                .build();

        Runway createdRunway = runwayRepository.save(runway);

        List<ClothesHasRunway> clothes = new ArrayList<>();
        for (Long clothesId : request.getClothesId()) {
            clothes.add(
                    ClothesHasRunway.builder()
                            .clothes(clothesRepository.findById(clothesId).orElseThrow(ClothesNotFoundException::new))
                            .runway(createdRunway)
                            .build()
            );
        }

        clothesHasRunwayRepository.saveAll(clothes);
    }

    @Override
    public void deleteRunway(Long runwayId) {
        Runway runway = runwayRepository.findById(runwayId).orElseThrow(RunwayNotFoundException::new);

        historyRepository.deleteAll(runway.getHistory());
        clothesHasRunwayRepository.deleteAll(clothesHasRunwayRepository.findAllByRunway(runway));
        runwayRepository.delete(runway);
    }

    @Override
    public RunwayListResponse getRunwayList(Long collectionId) {
        List<Runway> runwayList = runwayRepository.findAllByCollection(collectionRepository.findById(collectionId)
                .orElseThrow(CollectionNotFoundException::new));
        List<RunwayContentResponse> runwayContentList = new ArrayList<>();

        for (Runway runway : runwayList) {
            runwayContentList.add(
                    RunwayContentResponse.builder()
                            .id(runway.getId())
                            .runwayUrl(runway.getRunwayPath())
                            .count(historyRepository.findAllByRunway(runway).size())
                            .build()
            );
        }

        return new RunwayListResponse(runwayContentList);
    }

    @Override
    public RunwayDetailResponse getRunwayDetail(Long runwayId) {
        try {
            historyRepository.save(History.builder()
                    .runway(runwayRepository.findById(runwayId).orElseThrow(RunwayNotFoundException::new))
                    .user(userRepository.findById(authenticationFacade.getSub()).orElseThrow(UserNotFoundException::new))
                    .build());

            return runwayRepository.findById(runwayId)
                    .map(runway -> RunwayDetailResponse.builder()
                            .runwayUrl(runway.getRunwayPath())
                            .bgmPath(runway.getBgmPath())
                            .build())
                    .orElseThrow(RunwayNotFoundException::new);
        } catch (Exception e) {
            return runwayRepository.findById(runwayId)
                    .map(runway -> RunwayDetailResponse.builder()
                            .runwayUrl(runway.getRunwayPath())
                            .bgmPath(runway.getBgmPath())
                            .build())
                    .orElseThrow(RunwayNotFoundException::new);
        }
    }
}
