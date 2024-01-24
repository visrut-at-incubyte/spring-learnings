package com.example.demo.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
  private final PostRepository postRepository;

  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  public Optional<Post> getPostById(Long id) {
    return postRepository.findById(id);
  }

  public Post createPost(Post post) {
    return postRepository.save(post);
  }

  public Post updatePost(Long id, Post updatedPost) {
    return postRepository.findById(id)
        .map(post -> {
          post.setName(updatedPost.getName());
          post.setDetail(updatedPost.getDetail());
          return postRepository.save(post);
        })
        .orElse(null); // Handle not found scenario
  }

  public void deletePost(Long id) {
    postRepository.deleteById(id);
  }
}
