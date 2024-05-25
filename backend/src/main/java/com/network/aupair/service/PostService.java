package com.network.aupair.service;

import com.network.aupair.models.Post;
import com.network.aupair.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    private Post save(Post post){
        return postRepository.save(post);
    }

    private List<Post> list(){
        return postRepository.findAll();
    }

    private Post getById(String id){
        return postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity not found!"));
    }

    //TODO
    private Post update(String id, Post post){
        this.getById(id);
        return this.save(post);
    }

    private void delete(String id){
        postRepository.deleteById(id);
    }

}
