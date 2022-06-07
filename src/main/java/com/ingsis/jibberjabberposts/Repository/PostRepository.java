package com.ingsis.jibberjabberposts.Repository;


import com.ingsis.jibberjabberposts.Model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
//    @Query("SELECT u FROM Post u WHERE u.userId = ?1")
//    Optional<Post> findPostsByUserId(String userId);
//
////    @Query("select p from Post p where p.userId = ?1")
//    List<Post> findAllPostsByUserId(String userId);

    Page<Post> findAllPostByUserId(String userId, Pageable pageable);
}
