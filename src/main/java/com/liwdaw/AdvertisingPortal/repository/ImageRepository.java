package com.liwdaw.AdvertisingPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwdaw.AdvertisingPortal.entity.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

    public Image findById(int id);
    
    public List<Image> findByAdvertisementId(int id);
    
}
