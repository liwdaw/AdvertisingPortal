package com.liwdaw.AdvertisingPortal.DTO;

import com.liwdaw.AdvertisingPortal.entity.SubCategory;

import lombok.Data;

@Data
public class SubCategoryDTO {
    
    private int id;
    
    private String name;
    
    private CategoryDTO category;
    
    public SubCategoryDTO(SubCategory subCategory) {
        id = subCategory.getId();
        name = subCategory.getName();
        category = new CategoryDTO(subCategory.getCategory());
    }
    
}
