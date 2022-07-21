package com.ingsis.jibberjabberposts.Controller;

import com.ingsis.jibberjabberposts.Model.Post;
import com.ingsis.jibberjabberposts.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "v1/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @GetMapping(path = "/{postId}")
    public Optional<Post> getSinglePost(@PathVariable("postId") Long postId){return postService.getPostById(postId);}

    @PostMapping(path = "/add")
    public void createNewPost(@RequestBody Post post){
        postService.addNewPost(post);
    }

    @DeleteMapping(path = "{postId}")
    public void deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
    }

    @PutMapping(path = "/update/{postId}")
    public void updatePost(@PathVariable("postId") Long postId,
                           @RequestParam(required = false) String message) {
        postService.updatePost(postId,message);
    }
    @GetMapping(path = "/user/{userId}")
    public Page<Post> getPostsById(@PathVariable("userId") UUID userId){
        return postService.getPostsByUserId(userId);
    }
}
