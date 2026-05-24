package com.sms.repository;

import com.sms.entity.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProfileRepository extends CrudRepository<Profile, Integer> {

    Optional<Profile> findByUsername(String username);

    @Query("SELECT p FROM Profile p " +
            " WHERE p.username = ?1 AND p.password = ?2")
    Optional<Profile> findByUsernameAndPassword(String username, String password);

    Optional<Profile> findByToken(String userToken);
}
