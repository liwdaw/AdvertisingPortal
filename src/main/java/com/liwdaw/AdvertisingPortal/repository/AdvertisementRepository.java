package com.liwdaw.AdvertisingPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwdaw.AdvertisingPortal.entity.Advertisement;
import com.liwdaw.AdvertisingPortal.model.AdvertisementStatus;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Integer> {

    public Advertisement findByIdAndStatus(int id, AdvertisementStatus status);
       
    public List<Advertisement> findBySubCategoryIdAndStatus(int id, AdvertisementStatus status);
    
    public List<Advertisement> findBySubCategoryCategoryIdAndStatus(int id, AdvertisementStatus status);
    
    public List<Advertisement> findByStatus(AdvertisementStatus status);
    
    public List<Advertisement> findByUserEmail(String email);
    
    public List<Advertisement> findBySubCategoryCategoryIdAndStatusAndTitleContainingIgnoreCase(int id, AdvertisementStatus status, String search);
    
    public List<Advertisement> findBySubCategoryIdAndStatusAndTitleContainingIgnoreCase(int id, AdvertisementStatus status, String search);
    
    public List<Advertisement> findByStatusAndTitleContainingIgnoreCase(AdvertisementStatus status, String search);
    
}
