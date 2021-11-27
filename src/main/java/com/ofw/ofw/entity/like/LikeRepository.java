package com.ofw.ofw.entity.like;

import com.ofw.ofw.entity.brand.Brand;
import com.ofw.ofw.entity.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends CrudRepository<Like, LikeId> {

    List<Like> findAllByBrand(Brand brand);

    List<Like> findAllByUser(User user);
}

