package com.hyerim.book.springboot.web.controller.api;

import com.hyerim.book.springboot.service.party.PartyService;
import com.hyerim.book.springboot.web.dto.party.PartyResponseDto;
import com.hyerim.book.springboot.web.dto.party.PartySaveRequestDto;
import com.hyerim.book.springboot.web.dto.party.PartyUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PartyApiController {

    private final PartyService partyService;

    @PostMapping("/api/v1/party")
    public Long save(@RequestBody PartySaveRequestDto requestDto) {
        return partyService.saveParty(requestDto);
    }

    @PutMapping("/api/v1/party/{id}")
    public Long update(@PathVariable Long id, @RequestBody PartyUpdateRequestDto requestDto) {
        return partyService.updateParty(id, requestDto);
    }

    @GetMapping("/api/v1/party/{id}")
    public PartyResponseDto findById(@PathVariable Long id) {
        return partyService.findByIdInParty(id);
    }

    @DeleteMapping("/api/v1/party/{id}")
    public Long delete(@PathVariable Long id) {
        partyService.deleteParty(id);
        return id;
    }
}
