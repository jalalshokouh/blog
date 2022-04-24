package com.jalalshokouh.testspring.modules.post.controller;
import com.jalalshokouh.testspring.modules.post.entity.Category;
import com.jalalshokouh.testspring.modules.post.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/addCategory" , method = RequestMethod.POST)
    public Category addCategory (@RequestBody Category category){
         return categoryService.addCategory(category);
    }

    @RequestMapping(value = "/showCategories", method = RequestMethod.GET)
    public List<Category> showCategories (){
        return categoryService.ShowCategories();
    }
}
