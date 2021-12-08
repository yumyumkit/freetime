package com.hyerim.book.springboot.service.posts;

import com.hyerim.book.springboot.domain.posts.Posts;
import com.hyerim.book.springboot.domain.posts.PostsRepository;
import com.hyerim.book.springboot.web.dto.PostsListResponseDto;
import com.hyerim.book.springboot.web.dto.PostsResponseDto;
import com.hyerim.book.springboot.web.dto.PostsSaveRequestDto;
import com.hyerim.book.springboot.web.dto.PostsUpdateRequestDto;
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
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestsDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestsDto.getTitle(), requestsDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsResponseDto(entity);
    }

    //전체 글 내림차순 정렬
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        postsRepository.delete(posts);
    }

    //페이징 처리
    @Transactional
    public Page<Posts> getBoardList(Pageable pageable) {
        return postsRepository.findAll(pageable);
    }

    @Transactional
    public Boolean getListCheck(Pageable pageable) {
        Page<Posts> saved = getBoardList(pageable);
        Boolean check = saved.hasNext();

        return check;
    }

    //검색기능
    @Transactional
    public Page<Posts> search(String keyword, Pageable pageable) {

        Page<Posts> boardList = postsRepository.findByTitleContaining(keyword, pageable);

        return boardList;
    }

}
