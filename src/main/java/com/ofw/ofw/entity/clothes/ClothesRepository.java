package com.ofw.ofw.entity.clothes;

import com.ofw.ofw.entity.brand.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClothesRepository extends CrudRepository<Clothes, Long> {

    List<Clothes> findByNameStartsWithIgnoreCase(String filter);

    List<Clothes> findAllByBrand(Brand brand);
}
