package com.hyerim.book.springboot.domain.party;

import com.hyerim.book.springboot.domain.posts.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartyRepository extends JpaRepository<Party, Long> {

    // 순서대로 글 목록 보여주기
    @Query("SELECT p FROM Party p ORDER BY p.id DESC")
    List<Party> findAllDesc();

    Page<Party> findByTitleContaining(String keyword, Pageable pageable);

}
