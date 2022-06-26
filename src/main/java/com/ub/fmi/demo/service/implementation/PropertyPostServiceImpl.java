package com.ub.fmi.demo.service.implementation;

import com.ub.fmi.demo.domain.Photo;
import com.ub.fmi.demo.domain.PropertyPost;
import com.ub.fmi.demo.domain.User;
import com.ub.fmi.demo.repository.PhotoRepository;
import com.ub.fmi.demo.repository.PropertyPostRepository;
import com.ub.fmi.demo.repository.UserRepository;
import com.ub.fmi.demo.service.PropertyPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PropertyPostServiceImpl implements PropertyPostService {

    @Autowired
    private PropertyPostRepository propertyPostRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhotoRepository photoRepository;

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

    @Override
    public String uploadImage(Long id, byte[] bytes, String substring) {
        PropertyPost propertyPost = propertyPostRepository.findById(id).orElse(null);
        String image = Base64.encode(bytes);
        if (propertyPost != null) {
            Photo photo = new Photo(image, propertyPost);
            photoRepository.save(photo);
        }
        return image;
    }

    @Override
    public String uploadMainImage(Long id, byte[] bytes, String substring) {
        PropertyPost propertyPost = propertyPostRepository.findById(id).orElse(null);
        String image = Base64.encode(bytes);
        if (propertyPost != null) {
            propertyPost.setMainImage(image);
        }
        propertyPostRepository.save(propertyPost);
        return image;
    }

    @Override
    public List<String> getPhotos(Long propertyPostId) {
        PropertyPost propertyPost = propertyPostRepository.findById(propertyPostId).orElse(null);
        if (propertyPost != null) {
            List<Photo> photos = photoRepository.findAllByPropertyPost(propertyPost);
            return photos.stream().map(Photo::getPhoto).collect(Collectors.toList());
        }
        return null;
    }
}
