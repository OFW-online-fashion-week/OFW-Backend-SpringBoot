package com.ofw.ofw.entity.brand;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findAllByNameStartsWithIgnoreCase(String rating);
    Optional<Brand> findByEmail(String email);
}
