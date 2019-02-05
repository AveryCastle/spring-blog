package com.practice.github.springblog.controllers;

import com.practice.github.springblog.configurations.CustomUserDetails;
import com.practice.github.springblog.entities.Post;
import com.practice.github.springblog.services.PostService;
import com.practice.github.springblog.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class BlogController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping
    public List<Post> posts() {
        return postService.getAllPosts();
    }

    @PostMapping
    public Post save(@RequestBody Post post) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUserDetails customUserDetails = new CustomUserDetails(user);
        post.setUser(userService.loadUserByUsername(customUserDetails.getUsername()));
        return postService.save(post);
    }

    @GetMapping("/users/{username}")
    public List<Post> postsByUsername(@PathVariable String username) {
        return postService.findByUser(userService.findByUsername(username));
    }
}
