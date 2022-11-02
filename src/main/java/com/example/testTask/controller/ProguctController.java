/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testTask.controller;

import com.example.testTask.entity.ProductEntity;
import com.example.testTask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author agaja
 */
@RestController
@RequestMapping("/product")
public class ProguctController {
    
    @Autowired
    private ProductService productService;
    
    
    @GetMapping("/")
    public ResponseEntity getProducts(){
        try {
            return ResponseEntity.ok(productService.getProducts());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error: "+e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(productService.getProductById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error: "+e.getMessage());
        }
    }
    @PostMapping("/")
    public ResponseEntity addProduct(@RequestBody ProductEntity product,
                                        @RequestParam Long  categoryId){
        try {
            productService.addProduct(product, categoryId);
            return ResponseEntity.ok("created product");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }
    
    @PutMapping("/")
    public ResponseEntity updateCategory(@RequestBody ProductEntity product){
        try {
            return ResponseEntity.ok(productService.updateProduct(product));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("error");
        }
    }
    
    
}
