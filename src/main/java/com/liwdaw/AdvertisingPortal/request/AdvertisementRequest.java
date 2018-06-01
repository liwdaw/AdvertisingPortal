package com.liwdaw.AdvertisingPortal.request;

import java.util.List;

import lombok.Data;

@Data
public class AdvertisementRequest {
    
    private String title;
    
    private String description;
    
    private int price;
    
    private List<String> images;
    
    private int subCategoryId;
    
}
