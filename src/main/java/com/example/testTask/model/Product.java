/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.testTask.model;

import com.example.testTask.entity.ProductEntity;

/**
 *
 * @author agaja
 */
public class Product {
    private String productName;

    public static Product toModel(ProductEntity product){
        Product model = new Product();
        model.setProductName(product.getProduct_name());
        return model;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Product() {
    }
    
}
