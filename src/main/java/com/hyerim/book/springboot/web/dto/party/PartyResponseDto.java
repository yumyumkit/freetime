package com.hyerim.book.springboot.web.dto.party;

import com.hyerim.book.springboot.domain.party.Party;
import lombok.Getter;

/* 조회 dto */
@Getter
public class PartyResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PartyResponseDto(Party entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
