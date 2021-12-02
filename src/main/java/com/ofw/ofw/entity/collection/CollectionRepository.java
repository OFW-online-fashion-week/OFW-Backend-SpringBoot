package com.ofw.ofw.entity.collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long> {
    Page<Collection> findAllByOrderByCreatedAt(Pageable pageable);
    List<Collection> findAllByBrandId(Long brandId);
    List<Collection> findAllByBrandIdAndImplementFalse(Long brandId);
}
