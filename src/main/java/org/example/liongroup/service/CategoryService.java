package org.example.liongroup.service;

import org.example.liongroup.dto.CategoryDto;
import org.example.liongroup.model.Category;
import org.example.liongroup.model.Result;
import org.example.liongroup.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public List<Category> getAll(){
        return categoryRepo.findAll();
    }

    public Category getById(Long id){
        Optional<Category> byId = categoryRepo.findById(id);
        return byId.get();
    }

    public Result create(CategoryDto categoryDto){
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        categoryRepo.save(category);

        return new Result(true, "Category created");
    }

    public Result update(Long id, CategoryDto categoryDto){
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            category.setName(categoryDto.getName());
            category.setDescription(categoryDto.getDescription());
            categoryRepo.save(category);

            return new Result(true, "Category updated");
        }
        return new Result(false, "Category not found");
    }

    public Result delete(Long id){
        categoryRepo.deleteById(id);
        return new Result(true, "Category deleted");
    }
}
