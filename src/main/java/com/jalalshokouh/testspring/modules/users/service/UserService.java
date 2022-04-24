package com.jalalshokouh.testspring.modules.users.service;

import com.jalalshokouh.testspring.modules.users.entity.Users;
import com.jalalshokouh.testspring.modules.users.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users addUser (Users user) throws IOException {
        if (!(user.getUserPic().isEmpty())) {
            String path = ResourceUtils.getFile("classpath:static/userPic").getAbsolutePath();
            String name = UUID.randomUUID() + user.getUserPic().getOriginalFilename();
            byte[] bytes = user.getUserPic().getBytes();
            Files.write(Paths.get(path + File.separator + name), bytes);
            user.setCover(name);
        }
        return userRepository.save(user);
    }

    public List<Users> showUser (){
        return userRepository.findAll();
    }
}
