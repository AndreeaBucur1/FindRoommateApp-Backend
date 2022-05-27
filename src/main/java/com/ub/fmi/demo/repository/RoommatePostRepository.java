package com.ub.fmi.demo.repository;

import com.ub.fmi.demo.domain.RoommatePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoommatePostRepository extends JpaRepository<RoommatePost, Long> {

}
