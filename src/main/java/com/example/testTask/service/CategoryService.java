/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testTask.service;

import com.example.testTask.entity.CategoryEntity;
import com.example.testTask.model.Category;
import com.example.testTask.repository.CategoryRepo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agaja
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;
    
    public CategoryEntity addCategory(CategoryEntity category){
        return categoryRepo.save(category);
    }
    
    
    public Category getCategoryById(Long id){
        return Category.toModel( categoryRepo.findById(id).get());
    }
    
    public List<Category> getCategories(){
        List<Category> result = StreamSupport.stream(categoryRepo.findAll().spliterator(), false)
                .map(Category::toModel)
                .toList();
        return result;
    }
    
    public Category updateCategory(CategoryEntity category){
        return Category.toModel(categoryRepo.save(category));
    }
    
}
