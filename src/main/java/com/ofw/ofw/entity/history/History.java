package com.ofw.ofw.entity.history;

import com.ofw.ofw.entity.runway.Runway;
import com.ofw.ofw.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class History {
    @EmbeddedId
    private HistoryId historyId = new HistoryId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("runwayId")
    @JoinColumn(name = "runway_id")
    private Runway runway;

}
