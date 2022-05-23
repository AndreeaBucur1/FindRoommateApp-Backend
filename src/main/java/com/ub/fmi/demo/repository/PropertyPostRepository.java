package com.ub.fmi.demo.repository;

import com.ub.fmi.demo.domain.PropertyPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface PropertyPostRepository extends JpaRepository<PropertyPost, Long> {
    List<PropertyPost> findAllByIsForSale(Boolean isForSale);
}
