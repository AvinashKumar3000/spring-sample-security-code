package com.secruity.test.repository;

import com.secruity.test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // SELECT * FROM user WHERE email = ?
    Optional<User> findByEmail(String email);
}
