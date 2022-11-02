/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.testTask.repository;


import com.example.testTask.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author agaja
 */
public interface ProductRepo extends CrudRepository<ProductEntity, Long>  {

    public ProductEntity findAllById(Long id);
    
}
