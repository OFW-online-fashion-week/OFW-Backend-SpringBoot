package com.ofw.ofw.entity.brand;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findByNameStartsWithIgnoreCase(String rating);
}
