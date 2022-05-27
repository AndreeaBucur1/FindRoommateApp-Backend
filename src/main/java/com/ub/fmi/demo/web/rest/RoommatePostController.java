package com.ub.fmi.demo.web.rest;

import com.ub.fmi.demo.domain.RoommatePost;
import com.ub.fmi.demo.service.RoommatePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/find-roommate")
public class RoommatePostController {

    @Autowired
    private RoommatePostService roommatePostService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("")
    public List<RoommatePost> findAllPosts() {
        return roommatePostService.findAllPosts();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/{username}")
    public  RoommatePost createRoommatePost(@RequestBody RoommatePost roommatePost, @PathVariable("username") String username) {
        System.out.println(roommatePost);
        return roommatePostService.assignRoommatePostToUser(roommatePost, username);
    }


}
