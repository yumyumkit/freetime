package com.hyerim.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
/* Entity 클래스에서는 절대 Setter 메서드를 만들지 않는다. */
@Getter
@NoArgsConstructor //기본 생성자 자동 추가
@Entity
public class Posts extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //update 쿼리 작성 필요없이 field값 set만 해주면 자동으로 update 됨
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
