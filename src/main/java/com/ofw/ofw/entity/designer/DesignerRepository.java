package com.ofw.ofw.entity.designer;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DesignerRepository extends CrudRepository<Designer, Long> {
    List<Designer> findByNameContaining(String name);
}