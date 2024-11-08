package com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.repository;

import com.krillinator.Enterprise_Lektion_6_Spring_Security_Intro.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<CustomUser, Long> {

    Optional<CustomUser> findByUsername(String username);

}
