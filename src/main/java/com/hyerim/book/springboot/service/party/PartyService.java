package com.hyerim.book.springboot.service.party;

import com.hyerim.book.springboot.domain.party.Party;
import com.hyerim.book.springboot.domain.party.PartyRepository;
import com.hyerim.book.springboot.web.dto.party.PartyListResponseDto;
import com.hyerim.book.springboot.web.dto.party.PartyResponseDto;
import com.hyerim.book.springboot.web.dto.party.PartyUpdateRequestDto;
import com.hyerim.book.springboot.web.dto.party.PartySaveRequestDto;
import com.hyerim.book.springboot.web.dto.posts.PostsListResponseDto;
import jdk.nashorn.internal.ir.ReturnNode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PartyService {

    private final PartyRepository partyRepository;

    @Transactional
    public Long saveParty(PartySaveRequestDto requestDto) {
        return partyRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long updateParty(Long id, PartyUpdateRequestDto requestDto) {
        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        party.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional(readOnly = true)
    public PartyResponseDto findByIdInParty(Long id) {
        Party entity = partyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PartyResponseDto(entity);
    }

    //전체 글 내림차순 정렬
    @Transactional(readOnly = true)
    public List<PartyListResponseDto> findAllDescParty() {
        return partyRepository.findAllDesc().stream()
                .map(PartyListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteParty(Long id) {
        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        partyRepository.delete(party);
    }

    //페이징 처리
    @Transactional
    public Page<Party> getPartyList(Pageable pageable) {
        return partyRepository.findAll(pageable);
    }

    @Transactional
    public Boolean getPartyListCheck(Pageable pageable) {
        Page<Party> saved = getPartyList(pageable);
        Boolean partyCheck = saved.hasNext();

        return partyCheck;
    }

    //검색 기능
    @Transactional
    public Page<Party> searchParty(String keyword, Pageable pageable) {
        Page<Party> partyList = partyRepository.findByTitleContaining(keyword, pageable);

        return partyList;
    }
}
