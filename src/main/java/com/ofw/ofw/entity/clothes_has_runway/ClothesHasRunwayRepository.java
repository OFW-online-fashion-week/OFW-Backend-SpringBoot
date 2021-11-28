package com.ofw.ofw.entity.clothes_has_runway;

import com.ofw.ofw.entity.runway.Runway;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClothesHasRunwayRepository extends CrudRepository<ClothesHasRunway, Long> {

    List<ClothesHasRunway> findAllByRunway(Runway runway);
}
