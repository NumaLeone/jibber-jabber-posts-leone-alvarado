package com.ingsis.jibberjabberposts.Service;

import com.ingsis.jibberjabberposts.Model.Post;
import com.ingsis.jibberjabberposts.Repository.PostRepository;


import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    Pageable firstPageWithTwoElements = PageRequest.of(0,10);

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts(){
        return postRepository.findAll();
    }

    public Optional<Post> getPostById(Long postId){
        return postRepository.findById(postId);
    }

    public Page<Post> getPostsByUserId(String userId){return postRepository.findAllPostByUserId(userId,firstPageWithTwoElements);}

    public void addNewPost(Post post) {

//        Optional<Post> postOptional = postRepository.findPostByUserId(post.getUserId());
        postRepository.save(post);
        System.out.println(post.getUserId() + post.getMessage() + post.getId());
    }

    public void deletePost(Long postId) {
        if (!postRepository.existsById(postId)){
            throw new IllegalStateException("User id with id " + postId +" does not exist.");
        }
        postRepository.deleteById(postId);
    }

    @Transactional
    public void updatePost(Long postId, String message) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalStateException
                        ("Post id with id " + postId +" does not exist."));

        if(message != null && message.length()>0 && !Objects.equals(post.getMessage(), message)){
            post.setMessage(message);
        }
    }
}
