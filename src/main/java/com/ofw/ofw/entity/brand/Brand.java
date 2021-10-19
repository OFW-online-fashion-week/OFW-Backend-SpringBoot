package com.ofw.ofw.entity.brand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Brand {
    @Id
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
}
