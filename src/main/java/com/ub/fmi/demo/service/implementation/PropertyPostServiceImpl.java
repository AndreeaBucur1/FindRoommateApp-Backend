package com.ub.fmi.demo.service.implementation;

import com.ub.fmi.demo.domain.PropertyPost;
import com.ub.fmi.demo.repository.PropertyPostRepository;
import com.ub.fmi.demo.service.PropertyPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class PropertyPostServiceImpl implements PropertyPostService {

    @Autowired
    private PropertyPostRepository propertyPostRepository;

    @Override
    public PropertyPost createPost(PropertyPost propertyPost) {
        propertyPost.setCreationDate(LocalDateTime.now());
        return propertyPostRepository.save(propertyPost);
    }

    @Override
    public List<PropertyPost> getRentPosts() {
        return propertyPostRepository.findAllByPropertyForSaleRent("rent");
    }
}
