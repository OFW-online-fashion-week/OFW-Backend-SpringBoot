package com.ofw.ofw.entity.designer;

import com.ofw.ofw.payload.designer.response.SearchDesignerResponse;
import org.springframework.data.repository.CrudRepository;

public interface DesignerRepository extends CrudRepository<Designer, Long> {
    SearchDesignerResponse findByNameStartsWithIgnoreCase(String name);
}