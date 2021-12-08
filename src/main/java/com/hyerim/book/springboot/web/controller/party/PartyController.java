package com.hyerim.book.springboot.web.controller.party;

import com.hyerim.book.springboot.config.auth.LoginUser;
import com.hyerim.book.springboot.config.auth.dto.SessionUser;
import com.hyerim.book.springboot.domain.party.Party;
import com.hyerim.book.springboot.service.party.PartyService;
import com.hyerim.book.springboot.web.dto.party.PartyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PartyController {

    private final PartyService partyService;

    @GetMapping("/party")
    public String meeting(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @LoginUser SessionUser user) {
        model.addAttribute("parties", partyService.getPartyList(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("check", partyService.getPartyListCheck(pageable));
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "party/party-list";
    }

    @GetMapping("/party/{id}")
    public String posts(@PathVariable Long id, Model model) {
        PartyResponseDto dto = partyService.findByIdInParty(id);
        model.addAttribute("party", dto);
        return "party/party";
    }

    @GetMapping("/party/save")
    public String meetingSave(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "party/party-save";
    }

    @GetMapping("/party/update/{id}")
    public String partyUpdate(@PathVariable Long id, Model model) {
        PartyResponseDto dto = partyService.findByIdInParty(id);
        model.addAttribute("party", dto);

        return "party/party-update";
    }

    @GetMapping("/party/search")
    public String search(String keyword, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<Party> meetingSearchList = partyService.searchParty(keyword, pageable);

        model.addAttribute("meetingSearchList", meetingSearchList);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("check", partyService.getPartyListCheck(pageable));
        return "search/meetingSearchPage";
    }


}
