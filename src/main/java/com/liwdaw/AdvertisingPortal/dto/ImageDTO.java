package com.liwdaw.AdvertisingPortal.dto;

import com.liwdaw.AdvertisingPortal.entity.Image;

import lombok.Data;

@Data
public class ImageDTO {

    private int id;
    
    private String path;
    
    public ImageDTO(Image image) {
        id = image.getId();
        path = image.getPath();
    }
    
}
