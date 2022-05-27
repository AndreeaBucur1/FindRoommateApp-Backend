package com.ub.fmi.demo.web.rest;

import com.ub.fmi.demo.domain.PropertyPost;
import com.ub.fmi.demo.service.PropertyPostService;
import net.bytebuddy.build.CachedReturnPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property-posts")
public class PropertyPostController {

    @Autowired
    private PropertyPostService propertyPostService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/rent")
    public List<PropertyPost> getRentPosts(){
        return propertyPostService.getRentPosts();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sale")
    public  List<PropertyPost> getSales() {
        System.out.println("get sales");
        return propertyPostService.getSalePosts();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("")
    public PropertyPost createPropertyPost(@RequestBody PropertyPost propertyPost){
        return propertyPostService.createPost(propertyPost);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/{id}")
    public PropertyPost getPropertyPost(@PathVariable("id") Long id) {
        return propertyPostService.getPropertyPostById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/username/{username}")
    public List<PropertyPost> getPropertyPostsByUsername(@PathVariable("username") String username) {
        return  propertyPostService.getPropertyPostByUsername(username);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/{id}")
    public void  deleteById(@PathVariable("id") Long id) {
        propertyPostService.deleteById(id);
    }
}
