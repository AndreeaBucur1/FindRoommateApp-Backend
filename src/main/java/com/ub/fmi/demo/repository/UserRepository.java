package com.ub.fmi.demo.repository;

import com.ub.fmi.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByActivationToken(String token);

    @Override
    void delete(User user);
}
