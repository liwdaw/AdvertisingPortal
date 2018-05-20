package com.liwdaw.AdvertisingPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liwdaw.AdvertisingPortal.DTO.CategoryDTO;
import com.liwdaw.AdvertisingPortal.entity.Category;
import com.liwdaw.AdvertisingPortal.repository.CategoryRepository;

@Transactional
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<CategoryDTO> getAllCategories() {
        List<CategoryDTO> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(e->categories.add(new CategoryDTO(e)));
        return categories;
    }
    
    public CategoryDTO getCategory(int id) {
        CategoryDTO category = new CategoryDTO(categoryRepository.findById(id).get());
        return category;
    }
    
}
