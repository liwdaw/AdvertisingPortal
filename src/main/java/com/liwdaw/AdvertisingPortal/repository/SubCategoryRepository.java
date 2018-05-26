package com.liwdaw.AdvertisingPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwdaw.AdvertisingPortal.entity.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

    public SubCategory findById(int id);
    
    public SubCategory findByNameIgnoreCase(String name);
    
    public List<SubCategory> findByCategoryId(int id);
    
    public List<SubCategory> findByCategoryNameIgnoreCase(String name);
	
}
