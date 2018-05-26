package com.liwdaw.AdvertisingPortal.dto;

import com.liwdaw.AdvertisingPortal.entity.Category;

import lombok.Data;

@Data
public class CategoryDTO {

    private int id;
    
    private String name;
    
    public CategoryDTO(Category category) {
        id = category.getId();
        name = category.getName();
    }
    
}
