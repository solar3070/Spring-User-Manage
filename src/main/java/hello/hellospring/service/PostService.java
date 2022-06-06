package hello.hellospring.service;

import hello.hellospring.domain.Post;
import hello.hellospring.repository.PostRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    /**
     * 글 작성
     */
    public int save(Post post) {
        postRepository.save(post);
        return post.getPostId();
    }

    /**
     * 전체 글 조회
     */
    public List<Post> findPosts() {
        return postRepository.findAll();
    }

    /**
     * 특정 글 조회
     */
    public Optional<Post> findPost(int postId) {
        return postRepository.findById(postId);
    }

    /**
     * 특정 글 삭제
     */
    public void deletePost(int postId) {
        postRepository.deleteById(postId);
    }

}
