package com.practice.github.springblog.services;

import com.practice.github.springblog.entities.Post;
import com.practice.github.springblog.entities.User;
import com.practice.github.springblog.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findByUser(User user) {
        return postRepository.findByUserId(user.getId());
    }
}
