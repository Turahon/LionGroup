package org.example.liongroup.controller;

import org.example.liongroup.dto.CategoryDto;
import org.example.liongroup.model.Category;
import org.example.liongroup.model.Result;
import org.example.liongroup.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(Long id) {
        Category category = categoryService.getById(id);
        return category;
    }

    @PostMapping
    public Result create(CategoryDto categoryDto){
        Result result = categoryService.create(categoryDto);
        return result;
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Long id, CategoryDto categoryDto) {
        Result result = categoryService.update(id, categoryDto);
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        Result result = categoryService.delete(id);
        return result;
    }
}
