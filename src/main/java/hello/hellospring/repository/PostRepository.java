package hello.hellospring.repository;

import hello.hellospring.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findById(int postId);
    Optional<Post> findByTitle(String title);
    List<Post> findAll();
    void deleteById(int postId);
}
