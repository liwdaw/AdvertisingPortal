package com.liwdaw.AdvertisingPortal.request;

import java.util.Date;

import lombok.Data;

@Data
public class AdvertisementRequest {
    
    private String title;
    
    private String description;
    
    private int price;
    
    private int userId;
    
}
