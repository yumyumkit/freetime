package com.hyerim.book.springboot.web.dto.posts;

import com.hyerim.book.springboot.domain.posts.Posts;
import lombok.Getter;

//조회 dto
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
