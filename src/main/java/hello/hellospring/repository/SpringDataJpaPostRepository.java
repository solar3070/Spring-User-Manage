package hello.hellospring.repository;

import hello.hellospring.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaPostRepository extends JpaRepository<Post, Integer>, PostRepository {

    @Override
    Optional<Post> findByTitle(String title);
}
