package com.example.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostController {
  private final PostService postService;

  @Autowired
  public PostController(PostService postService) {
    this.postService = postService;
  }

  @GetMapping
  public List<Post> getAllPosts() {
    return postService.getAllPosts();
  }

  @GetMapping("/{id}")
  public Optional<Post> getPostById(@PathVariable Long id) {
    return postService.getPostById(id);
  }

  @PostMapping
  public Post createPost(@RequestBody Post post) {
    return postService.createPost(post);
  }

  @PutMapping("/{id}")
  public Post updatePost(@PathVariable Long id, @RequestBody Post updatedPost) {
    return postService.updatePost(id, updatedPost);
  }

  @DeleteMapping("/{id}")
  public void deletePost(@PathVariable Long id) {
    postService.deletePost(id);
  }
}
