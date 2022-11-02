/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testTask.model;

import com.example.testTask.entity.CategoryEntity;
import java.util.List;

/**
 *
 * @author agaja
 */
public class Category {
    private Long id;
    private String category_name;
    private List<Product> poducts;

    public List<Product> getPoducts() {
        return poducts;
    }

    public void setPoducts(List<Product> poducts) {
        this.poducts = poducts;
    }
    
    public static Category toModel(CategoryEntity category){
        Category model = new Category();
        model.setId(category.getId());
        model.setCategory_name(category.getCategory_name());
        model.setPoducts(category.getProducts().stream().map(Product::toModel).toList());
        return model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
    public Category() {
    }
    
}
