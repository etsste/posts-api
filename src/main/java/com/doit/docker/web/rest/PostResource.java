package com.doit.docker.web.rest;

import com.doit.docker.domain.Post;
import com.doit.docker.repository.PostRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostResource {

    private final Logger log = LoggerFactory.getLogger(PostResource.class);


    private PostRepository postRepository;

    public PostResource(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping("/posts")
    public Post createPost(@RequestBody Post post) {
        log.info("createPost");
        return postRepository.save(post);
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(Pageable pageable) {
        log.info("getAllPosts");
        return postRepository.findAll(pageable).getContent();
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Long id) {
        log.info("getPost");
        return postRepository.findById(id).orElseThrow(() -> new RuntimeException("Yok boyle bi sey"));
    }

    @PutMapping("/posts")
    public Post updatePost(@RequestBody Post post) {
        log.info("updatePost");
        return postRepository.save(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable Long id) {
        log.info("deletePost");
        postRepository.deleteById(id);
    }

}
