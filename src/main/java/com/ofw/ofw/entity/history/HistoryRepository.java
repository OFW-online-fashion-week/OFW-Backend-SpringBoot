package com.ofw.ofw.entity.history;

import com.ofw.ofw.entity.runway.Runway;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface HistoryRepository extends CrudRepository<History, HistoryId> {
    List<History> findAllByRunway(Runway runway);
}
