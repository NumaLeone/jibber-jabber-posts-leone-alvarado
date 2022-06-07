package com.ingsis.jibberjabberposts.config;

import com.ingsis.jibberjabberposts.Model.Post;
import com.ingsis.jibberjabberposts.Repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PostConfig {
    @Bean
    CommandLineRunner commandLineRunner(PostRepository respository){
        return args -> {
            Post numa = new Post("My first tweet", "numa");
            Post alex = new Post("Alex first tweet", "alex");
            List<Post> testPosts = new ArrayList<>();
            testPosts.add(numa);
            testPosts.add(alex);
            respository.saveAll(testPosts);
        };
    }
}
