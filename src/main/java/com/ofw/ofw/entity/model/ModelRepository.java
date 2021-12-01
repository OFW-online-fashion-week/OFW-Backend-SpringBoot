package com.ofw.ofw.entity.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ModelRepository extends CrudRepository<Model, Long> {
    List<Model> findByNameStartsWithIgnoreCase(String filter);
}
