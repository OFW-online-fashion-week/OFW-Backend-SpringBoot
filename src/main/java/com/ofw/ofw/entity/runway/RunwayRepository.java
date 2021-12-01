package com.ofw.ofw.entity.runway;

import com.ofw.ofw.entity.collection.Collection;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RunwayRepository extends CrudRepository<Runway, Long> {

    List<Runway> findAllByCollection(Collection collection);
}
