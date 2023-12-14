package com.ra.md05ss06miniprojectorderapi.repository;

import com.ra.md05ss06miniprojectorderapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
