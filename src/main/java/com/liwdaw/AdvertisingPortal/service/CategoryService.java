package com.liwdaw.AdvertisingPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.liwdaw.AdvertisingPortal.entity.Category;
import com.liwdaw.AdvertisingPortal.repository.CategoryRepository;

public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public Category getCategory(int id) {
        return categoryRepository.findById(id).get();
    }
    
}
