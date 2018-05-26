package com.liwdaw.AdvertisingPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liwdaw.AdvertisingPortal.dto.CategoryDTO;
import com.liwdaw.AdvertisingPortal.repository.CategoryRepository;

@Transactional
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;
    
    public CategoryDTO getCategoryById(int id) {
        CategoryDTO category = new CategoryDTO(repository.findById(id));
        return category;
    }
    
    public CategoryDTO getCategoryByName(String name) {
        CategoryDTO category = new CategoryDTO(repository.findByName(name));
        return category;
    }
    
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categories = new ArrayList<>();
        repository.findAll().forEach(e->categories.add(new CategoryDTO(e)));
        return categories;
    }
    
}
