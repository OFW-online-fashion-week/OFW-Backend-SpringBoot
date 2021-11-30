package com.ofw.ofw.entity.designer;

import org.springframework.data.repository.CrudRepository;

public interface DesignerRepository extends CrudRepository<Designer, Long> {
    Designer findByNameContaining(String name);
}