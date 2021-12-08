package com.hyerim.book.springboot.service.posts;

import com.hyerim.book.springboot.domain.posts.Posts;
import com.hyerim.book.springboot.domain.posts.PostsRepository;
import com.hyerim.book.springboot.web.dto.posts.PostsListResponseDto;
import com.hyerim.book.springboot.web.dto.posts.PostsResponseDto;
import com.hyerim.book.springboot.web.dto.posts.PostsSaveRequestDto;
import com.hyerim.book.springboot.web.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long savePost(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long updatePost(Long id, PostsUpdateRequestDto requestsDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestsDto.getTitle(), requestsDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findByIdInPost(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    //전체 글 내림차순 정렬
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDescPost() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletePost(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    //페이징 처리
    @Transactional
    public Page<Posts> getPostList(Pageable pageable) {
        return postsRepository.findAll(pageable);
    }

    @Transactional
    public Boolean getPostListCheck(Pageable pageable) {
        Page<Posts> saved = getPostList(pageable);
        Boolean postCheck = saved.hasNext();

        return postCheck;
    }

    //검색기능
    @Transactional
    public Page<Posts> searchPost(String postsKeyword, Pageable pageable) {

        Page<Posts> postList = postsRepository.findByTitleContaining(postsKeyword, pageable);

        return postList;
    }

}
