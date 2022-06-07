package hello.hellospring.controller;

import hello.hellospring.domain.Post;
import hello.hellospring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/new")
    public String createForm() {
        return "post/createPostForm";
    }

    @PostMapping("/post/new")
    public String create(PostForm form) {
        Post post = new Post();
        post.setTitle(form.getTitle());
        post.setDesc(form.getDesc());
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/post/list")
    public String list(Model model) {
        List<Post> posts = postService.findPosts();
        model.addAttribute("posts", posts);
        return "post/postList";
    }

    @GetMapping("/post")
    public String detail(@RequestParam("postId") int postId, Model model) {
        Post post = postService.findPost(postId).get();
        model.addAttribute("post", post);
        return "post/postDetail";
    }

    @GetMapping("/post/edit")
    public String edit(@RequestParam("postId") int postId, Model model) {
        Post post = postService.findPost(postId).get();
        model.addAttribute("post", post);
        return "post/postUpdate";
    }

    @PutMapping("/post/edit")
    public String update(Post post) {
        postService.save(post);
        return "redirect:/";
    }

    @DeleteMapping("/post")
    public String delete(@RequestParam("postId") int postId) {
        postService.deletePost(postId);
        return "redirect:/";
    }
}
