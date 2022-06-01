package com.ub.fmi.demo.service;

import com.ub.fmi.demo.domain.RoommatePost;
import com.ub.fmi.demo.web.rest.dto.RoommatePostDTO;

import java.util.List;

public interface RoommatePostService {
    List<RoommatePostDTO> findAllPosts();

    RoommatePost assignRoommatePostToUser(RoommatePost roommatePost, String username);
}
