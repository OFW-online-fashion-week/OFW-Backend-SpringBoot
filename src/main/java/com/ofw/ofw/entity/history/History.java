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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("runway_id")
    @JoinColumn(name = "runway_id")
    private Runway runway;

}
