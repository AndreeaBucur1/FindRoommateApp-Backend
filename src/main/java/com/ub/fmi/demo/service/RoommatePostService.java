package com.ub.fmi.demo.service;

import com.ub.fmi.demo.domain.RoommatePost;

import java.util.List;

public interface RoommatePostService {
    List<RoommatePost> findAllPosts();

    RoommatePost assignRoommatePostToUser(RoommatePost roommatePost, String username);
}
