package com.ub.fmi.demo.service;

import com.ub.fmi.demo.domain.PropertyPost;

import java.util.List;

public interface PropertyPostService {
    PropertyPost createPost(PropertyPost propertyPost);

    List<PropertyPost> getRentPosts();

    List<PropertyPost> getSalePosts();

    PropertyPost getPropertyPostById(Long id);

    List<PropertyPost> getPropertyPostByUsername(String username);

    void deleteById(Long id);

    String uploadImage(Long id, byte[] bytes, String substring);

    String uploadMainImage(Long id, byte[] bytes, String substring);
}
