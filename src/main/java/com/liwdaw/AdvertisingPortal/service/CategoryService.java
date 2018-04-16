package com.liwdaw.AdvertisingPortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liwdaw.AdvertisingPortal.entity.Category;
import com.liwdaw.AdvertisingPortal.repository.CategoryRepository;

@Transactional
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public Category getCategory(int id) {
        return categoryRepository.findById(id).get();
    }
    
}
