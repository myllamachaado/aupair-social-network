package com.network.aupair.controller;

import com.network.aupair.repository.PostRepository;
import com.network.aupair.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostRepository postRepository;
    private final PostService postService;

    public PostController(PostRepository postRepository, PostService postService) {
        this.postRepository = postRepository;
        this.postService = postService;
    }

    private void getPosts(){

    }

    private void getPost(){

    }

    private void savePost(){

    }

    private void editPost(){

    }

    private void deletePost(){

    }

}
