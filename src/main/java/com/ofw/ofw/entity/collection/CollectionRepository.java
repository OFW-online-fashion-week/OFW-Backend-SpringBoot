package com.ofw.ofw.entity.collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends CrudRepository<Collection, Long> {
    Page<Collection> findAllByOrderByCreatedAt(Pageable pageable);
}
