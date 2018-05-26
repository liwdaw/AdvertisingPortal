package com.liwdaw.AdvertisingPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liwdaw.AdvertisingPortal.dto.SubCategoryDTO;
import com.liwdaw.AdvertisingPortal.repository.SubCategoryRepository;

@Transactional
@Service
public class SubCategoryService {

	@Autowired
	private SubCategoryRepository repository;
    
    public SubCategoryDTO getSubCategoryById(int id) {
        SubCategoryDTO subCategory = new SubCategoryDTO(repository.findById(id));
        return subCategory;
    }
    
    public SubCategoryDTO getSubCategoryByName(String name) {
        SubCategoryDTO subCategory = new SubCategoryDTO(repository.findByNameIgnoreCase(name));
        return subCategory;
    }
    
    public List<SubCategoryDTO> getSubCategoriesByCategoryId(int id) {
        List<SubCategoryDTO> subCategories = new ArrayList<>();
        repository.findByCategoryId(id).forEach(e->subCategories.add(new SubCategoryDTO(e)));
        return subCategories;
    }
    
    public List<SubCategoryDTO> getSubCategoriesByCategoryName(String name) {
        List<SubCategoryDTO> subCategories = new ArrayList<>();
        repository.findByCategoryNameIgnoreCase(name).forEach(e->subCategories.add(new SubCategoryDTO(e)));
        return subCategories;
    }
    
    public List<SubCategoryDTO> getAllSubCategories() {
        List<SubCategoryDTO> subCategories = new ArrayList<>();
        repository.findAll().forEach(e->subCategories.add(new SubCategoryDTO(e)));
        return subCategories;
    }
	
}
