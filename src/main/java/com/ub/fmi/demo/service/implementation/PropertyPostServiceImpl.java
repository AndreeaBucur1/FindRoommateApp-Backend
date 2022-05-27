package com.ub.fmi.demo.service.implementation;

import com.ub.fmi.demo.domain.PropertyPost;
import com.ub.fmi.demo.domain.User;
import com.ub.fmi.demo.repository.PropertyPostRepository;
import com.ub.fmi.demo.repository.UserRepository;
import com.ub.fmi.demo.service.PropertyPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class PropertyPostServiceImpl implements PropertyPostService {

    @Autowired
    private PropertyPostRepository propertyPostRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public PropertyPost createPost(PropertyPost propertyPost) {
        propertyPost.setCreationDate(LocalDateTime.now());
        return propertyPostRepository.save(propertyPost);
    }

    @Override
    public List<PropertyPost> getRentPosts() {
        return propertyPostRepository.findAllByIsForSale(false);
    }

    @Override
    public List<PropertyPost> getSalePosts() {
        System.out.println(propertyPostRepository.findAllByIsForSale(true));
        return propertyPostRepository.findAllByIsForSale(true);
    }

    @Override
    public PropertyPost getPropertyPostById(Long id) {
        return propertyPostRepository.findById(id).orElse(null);
    }

    @Override
    public List<PropertyPost> getPropertyPostByUsername(String username) {
        return propertyPostRepository.findAllByUser_Username(username);
    }

    @Override
    public void deleteById(Long id) {
        propertyPostRepository.deleteById(id);
    }
}
