package com.hyerim.book.springboot.web.dto.party;

import com.hyerim.book.springboot.domain.party.Party;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/* 모임 작성 dto */
@Getter
@NoArgsConstructor
public class PartySaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PartySaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Party toEntity() {
        return Party.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
