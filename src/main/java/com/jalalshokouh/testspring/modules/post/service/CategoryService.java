package com.jalalshokouh.testspring.modules.post.service;

import com.jalalshokouh.testspring.modules.post.entity.Category;
import com.jalalshokouh.testspring.modules.post.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private ICategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public Category addCategory (Category category){
        return categoryRepository.save(category);
    }

    public List<Category> ShowCategories (){
        return categoryRepository.findAll();
    }
}
