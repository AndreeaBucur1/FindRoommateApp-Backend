package com.ub.fmi.demo.service;

import com.ub.fmi.demo.domain.PropertyPost;

import java.util.List;

public interface PropertyPostService {
    PropertyPost createPost(PropertyPost propertyPost);

    List<PropertyPost> getRentPosts();
}
