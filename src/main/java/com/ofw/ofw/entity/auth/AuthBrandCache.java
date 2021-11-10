package com.ofw.ofw.entity.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Getter
@AllArgsConstructor
@Builder
@RedisHash
public class AuthBrandCache {

    @TimeToLive(unit = TimeUnit.DAYS)
    private Long timeToLive;

    @Id
    private String email;

    private String profileFile;

    private String coverFile;

    private String password;

    private String name;

    private String url;

    private String description;

    @CreatedDate
    private LocalDateTime createdAt;
}
