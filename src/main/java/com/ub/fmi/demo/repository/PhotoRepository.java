package com.ub.fmi.demo.repository;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.ub.fmi.demo.domain.Photo;
import com.ub.fmi.demo.domain.PropertyPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhotoRepository extends JpaRepository<Photo, Long> {

    List<Photo> findAllByPropertyPost(PropertyPost propertyPost);
}
