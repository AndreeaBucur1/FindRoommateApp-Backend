package com.ub.fmi.demo.web.rest;

import com.ub.fmi.demo.domain.PropertyPost;
import com.ub.fmi.demo.service.PropertyPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property-posts")
public class PropertyPostController {

    @Autowired
    private PropertyPostService propertyPostService;

    @GetMapping("/rent")
    public List<PropertyPost> getRentPosts(){
        return propertyPostService.getRentPosts();
    }

    @GetMapping("/sale")
    public  List<PropertyPost> getSales() { return propertyPostService.getSalePosts();}

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping()
    public PropertyPost createPropertyPost(@RequestBody PropertyPost propertyPost){
        return propertyPostService.createPost(propertyPost);
    }

}
