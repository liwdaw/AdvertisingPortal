package com.liwdaw.AdvertisingPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwdaw.AdvertisingPortal.entity.Advertisement;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {

    public Advertisement findByIdAndStatus(int id, String status);
    
    public List<Advertisement> findByUserIdAndStatus(int id, String status);
       
    public List<Advertisement> findBySubCategoryIdAndStatus(int id, String status);
    
    public List<Advertisement> findBySubCategoryCategoryIdAndStatus(int id, String status);
    
}
