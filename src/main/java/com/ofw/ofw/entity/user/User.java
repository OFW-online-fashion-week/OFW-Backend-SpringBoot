package com.ofw.ofw.entity.user;

import com.ofw.ofw.entity.like.Like;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String email;

    @Column(nullable = false, length = 10)
    private String name;

    public User update(String name) {
        this.name = name;
        return this;
    }

    @OneToMany(fetch = FetchType.LAZY)
    private List<Like> like;
}
