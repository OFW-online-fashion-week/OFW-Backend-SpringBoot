package com.ofw.ofw.entity.collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<Collection, Long>, QuerydslRepository {
    Page<Collection> findAllByOrderByCreatedAt(Pageable pageable);
}
