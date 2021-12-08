package com.hyerim.book.springboot.web.controller.posts;

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

@RequiredArgsConstructor
@Controller
public class PostsController {

    private final PostsService postsService;

    @GetMapping("/posts")
    public String sharing(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.getPostList(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("check", postsService.getPostListCheck(pageable));
        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userImage", user.getPicture());
        }

        return "post/post-list";
    }

    @GetMapping("/posts/{id}")
    public String posts(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findByIdInPost(id);
        model.addAttribute("post", dto);
        return "post/post";
    }

    @GetMapping("/posts/save")
    public String postsSave(Model model, @LoginUser SessionUser user) {
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "post/posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findByIdInPost(id);
        model.addAttribute("post", dto);

        return "post/posts-update";
    }

    @GetMapping("/posts/search")
    public String postSearch(String keyword, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        Page<Posts> sharingSearchList = postsService.searchPost(keyword, pageable);

        model.addAttribute("sharingSearchList", sharingSearchList);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        model.addAttribute("check", postsService.getPostListCheck(pageable));
        return "search/sharingSearchPage";
    }

}
