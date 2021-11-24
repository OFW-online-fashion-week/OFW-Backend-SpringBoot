package com.ofw.ofw.entity.designer;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.collection_designer.Collection_designer;
import com.ofw.ofw.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Designer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 25)
    private String email;

    @Column(nullable = false, length = 20)
    private String name;

    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Collection_designer> collection_designer;
}
