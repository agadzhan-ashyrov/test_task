/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testTask.controller;

import com.example.testTask.entity.CategoryEntity;
import com.example.testTask.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author agaja
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;
    
    
    @GetMapping("/")
    public ResponseEntity getCategories(){
        try {
            return ResponseEntity.ok(categoryService.getCategories());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error: "+e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getCategories(@PathVariable Long id){
        try {
            return ResponseEntity.ok(categoryService.getCategoryById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error: "+e.getMessage());
        }
    }
    
    @PostMapping("/")
    public ResponseEntity addCategory(@RequestBody CategoryEntity category){
        try {
            return ResponseEntity.ok(categoryService.addCategory(category));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }
    
    @PutMapping("/")
    public ResponseEntity updateCategory(@RequestBody CategoryEntity category){
        try {
            return ResponseEntity.ok(categoryService.updateCategory(category));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }
}
