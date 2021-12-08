package com.hyerim.book.springboot.web.controller.api;

import com.hyerim.book.springboot.service.posts.PostsService;
import com.hyerim.book.springboot.web.dto.posts.PostsResponseDto;
import com.hyerim.book.springboot.web.dto.posts.PostsSaveRequestDto;
import com.hyerim.book.springboot.web.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.savePost(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.updatePost(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findByIdInPost(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.deletePost(id);
        return id;
    }
}
