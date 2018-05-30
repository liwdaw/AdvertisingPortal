package com.liwdaw.AdvertisingPortal.dto;

import java.sql.Blob;

import com.liwdaw.AdvertisingPortal.entity.Image;

import lombok.Data;

@Data
public class ImageDTO {

    private int id;
    
    private Blob image;
    
    public ImageDTO(Image image) {
        id = image.getId();
        this.image = image.getImage();
    }
    
}
