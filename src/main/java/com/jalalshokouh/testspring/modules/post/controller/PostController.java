package com.jalalshokouh.testspring.modules.post.controller;
import com.jalalshokouh.testspring.modules.post.entity.Post;
import com.jalalshokouh.testspring.modules.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.io.IOException;

@Controller
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping(value = "/registerPost")
    public String showPost(Model model,Post post){
        model.addAttribute("postData" , new Post());
        return "registerPost";
    }

    @PostMapping(value = "/registerPost")
    public String addPost(@ModelAttribute(value = "postData") Post post) throws IOException {
        postService.addPost(post);
        System.out.println(post.toString());
        return "successRegister";
    }
}
