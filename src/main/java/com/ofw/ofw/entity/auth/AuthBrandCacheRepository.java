package com.ofw.ofw.entity.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthBrandCacheRepository extends CrudRepository<AuthBrandCache, String> {
}
