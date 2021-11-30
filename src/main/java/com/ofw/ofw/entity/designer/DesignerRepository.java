package com.ofw.ofw.entity.designer;

import com.ofw.ofw.payload.designer.response.SerachDesignerResponse;
import org.springframework.data.repository.CrudRepository;

public interface DesignerRepository extends CrudRepository<Designer, Long> {
    SerachDesignerResponse findByNameStartsWithIgnoreCase(String name);
}