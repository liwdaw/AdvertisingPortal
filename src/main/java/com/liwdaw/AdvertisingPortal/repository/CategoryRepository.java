package com.liwdaw.AdvertisingPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwdaw.AdvertisingPortal.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
    public Category findById(int id);
    
    public Category findByNameIgnoreCase(String name);
      
}
