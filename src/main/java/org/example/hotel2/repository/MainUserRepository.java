package org.example.hotel2.repository;

import org.example.hotel2.entity.MainUser;
import org.example.hotel2.enums.MainUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainUserRepository extends JpaRepository<MainUser, Long> {

    Optional<MainUser> findMainUserByEmail(String email);

    Optional<MainUser> findByMainUserRole(MainUserRole mainUserRole);
}
