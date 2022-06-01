package com.ub.fmi.demo.repository;

import com.ub.fmi.demo.domain.RoommatePost;
import com.ub.fmi.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByActivationToken(String token);
    List<User> findAllByAccountActivatedTrue();
    Optional<User> findByEmail(String email);
    Optional<User> findByResetPasswordToken(String token);

    Optional<User> findByRoommatePost(RoommatePost roommatePost);

    @Override
    void delete(User user);
}
