package com.ub.fmi.demo.service.implementation;

import com.ub.fmi.demo.domain.RoommatePost;
import com.ub.fmi.demo.domain.User;
import com.ub.fmi.demo.repository.RoommatePostRepository;
import com.ub.fmi.demo.repository.UserRepository;
import com.ub.fmi.demo.service.RoommatePostService;
import com.ub.fmi.demo.web.rest.dto.RoommatePostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoommatePostServiceImpl implements RoommatePostService {

    @Autowired
    private RoommatePostRepository roommatePostRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<RoommatePostDTO> findAllPosts() {
        List<RoommatePost> roommatePosts = roommatePostRepository.findAll();
        List<RoommatePostDTO> roommatePostDTOs = new ArrayList<>();
        for (RoommatePost roommatePost : roommatePosts) {
            User user = userRepository.findByRoommatePost(roommatePost).orElse(null);
            if (user != null) {
                roommatePostDTOs.add(new RoommatePostDTO(roommatePost, user));
            }
        }
        return roommatePostDTOs;
    }

    @Override
    public RoommatePost assignRoommatePostToUser(RoommatePost roommatePost, String username) {
        System.out.println(username);
        User user = userRepository.findByUsername(username).orElse(null);
        if (user != null) {
            roommatePost.setHasGender(user.getGender());
            user.setRoommatePost(createRoommatePost(roommatePost));
            userRepository.save(user);
            return roommatePost;
        }
        return null;
    }

    public RoommatePost createRoommatePost(RoommatePost roommatePost) {
        return roommatePostRepository.save(roommatePost);
    }
}
