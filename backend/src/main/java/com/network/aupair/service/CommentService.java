package com.network.aupair.service;

import com.network.aupair.models.Comment;
import com.network.aupair.repository.CommentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> list(){
        return commentRepository.findAll();
    }

    public Comment getById(String id){
        return commentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    //TODO
    public Comment update(String id, Comment comment){
        this.getById(id);
        return save(comment);
    }

    public void delete(String id){
        commentRepository.deleteById(id);
    }

}
