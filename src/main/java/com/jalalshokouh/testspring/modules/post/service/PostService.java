package com.jalalshokouh.testspring.modules.post.service;

import com.jalalshokouh.testspring.modules.post.entity.Post;
import com.jalalshokouh.testspring.modules.post.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PostService {
    private IPostRepository postRepository;

    @Autowired
    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Transactional
    public Post addPost(Post post) throws IOException {

            byte[] bytes = post.getMultipartFile().getBytes();
            Files.write(Paths.get("C:\\Users\\jalalshokouh\\IdeaProjects\\testspring\\target\\classes\\static\\img" + File.separator + post.getMultipartFile().getOriginalFilename()), bytes);

        return this.postRepository.save(post);
    }

    public List<Post> showPost (){
        return postRepository.findAll();
    }
}
