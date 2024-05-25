package com.network.aupair.controller;

import com.network.aupair.repository.CommentRepository;
import com.network.aupair.service.CommentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    private final CommentRepository commentRepository;
    private final CommentService commentService;

    public CommentController(CommentRepository commentRepository, CommentService commentService) {
        this.commentRepository = commentRepository;
        this.commentService = commentService;
    }

    private void getComments(){

    }

    private void getComment(){

    }

    private void saveComment(){

    }

    private void editComment(){

    }

    private void deleteComment(){

    }

}
