package com.hyerim.book.springboot.web;

import com.hyerim.book.springboot.config.auth.LoginUser;
import com.hyerim.book.springboot.config.auth.dto.SessionUser;
import com.hyerim.book.springboot.domain.posts.Posts;
import com.hyerim.book.springboot.service.posts.PostsService;
import com.hyerim.book.springboot.web.dto.posts.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.WebParam;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userImage", user.getPicture());
        }
        return "index";
    }

}
