package com.ofw.ofw.entity.brand;

import com.ofw.ofw.entity.clothes.Clothes;
import com.ofw.ofw.entity.collection.Collection;
import com.ofw.ofw.entity.like.Like;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false, length = 250)
    private String profile_path;

    @Column(nullable = false, length = 250)
    private String cover_path;

    @Column(nullable = false, length = 100)
    private String url;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "collection", fetch = FetchType.LAZY)
    private List<Collection> collection;

    @OneToMany(mappedBy = "like", fetch = FetchType.LAZY)
    private List<Like> like;

    @OneToMany(mappedBy = "clothes", fetch = FetchType.LAZY)
    private List<Clothes> clothes;

}
