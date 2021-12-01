package com.ofw.ofw.entity.profile;

import com.ofw.ofw.entity.model.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    Optional<Profile> findByModel(Model model);
}
