package com.jalalshokouh.testspring.modules.post.repository;

import com.jalalshokouh.testspring.modules.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post , Long> {
}
