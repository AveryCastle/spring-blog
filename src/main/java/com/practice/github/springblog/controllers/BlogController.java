package com.practice.github.springblog.controllers;

import com.practice.github.springblog.entities.Post;
import com.practice.github.springblog.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
        return postService.save(post);
    }
}
