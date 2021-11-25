package com.ofw.ofw.entity.history;

import com.ofw.ofw.entity.runway.Runway;
import com.ofw.ofw.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Embeddable
public class HistoryId implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "runway_id")
    private Long runwayId;

}
