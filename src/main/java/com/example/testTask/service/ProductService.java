/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testTask.service;

import com.example.testTask.entity.CategoryEntity;
import com.example.testTask.entity.ProductEntity;
import com.example.testTask.model.Product;
import com.example.testTask.repository.CategoryRepo;
import com.example.testTask.repository.ProductRepo;
import java.util.List;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author agaja
 */
@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    
    @Autowired
    private CategoryRepo categoryRepo;
    
    public ProductEntity getProductById(Long id){
        return productRepo.findAllById(id);
    } 
    
    public List<Product> getProducts(){
        return StreamSupport.stream(productRepo.findAll().spliterator(), false)
                .map(Product::toModel)
                .toList();
    }
    public ProductEntity addProduct(ProductEntity product, Long categoryId){
        CategoryEntity category = categoryRepo.findById(categoryId).get();
        product.setCategory(category);
        return productRepo.save(product);
    }
    
    public ProductEntity updateProduct(ProductEntity product){
        return productRepo.save(product);
    }
}
