package com.bank.credit.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bank.credit.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);   // ✅ add this
    Optional<User> findByEmail(String email);         // ✅ add this
    boolean existsByUsername(String username);        // ✅ add this
    boolean existsByEmail(String email);              // ✅ add this
}