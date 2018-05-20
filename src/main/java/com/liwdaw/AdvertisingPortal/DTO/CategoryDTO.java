package com.liwdaw.AdvertisingPortal.DTO;

import java.sql.Blob;

import com.liwdaw.AdvertisingPortal.entity.Category;

import lombok.Data;

@Data
public class CategoryDTO {

    private int categoryID;
    
    private String name;
    
    private Blob icon;
    
    public CategoryDTO(Category category) {
        this.categoryID = category.getCategoryID();
        this.name = category.getName();
        this.icon = category.getIcon();
    }
    
}
