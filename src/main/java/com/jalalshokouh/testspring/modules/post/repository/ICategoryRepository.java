package com.jalalshokouh.testspring.modules.post.repository;

import com.jalalshokouh.testspring.modules.post.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {
}
