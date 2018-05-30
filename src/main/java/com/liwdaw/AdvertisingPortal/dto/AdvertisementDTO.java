package com.liwdaw.AdvertisingPortal.dto;

import java.util.Date;
import java.util.List;

import com.liwdaw.AdvertisingPortal.entity.Advertisement;

import lombok.Data;

@Data
public class AdvertisementDTO {

    private int id;
    
    private String title;
    
    private String description;
    
    private int price;
    
    private Date addDate;
    
    private Date refreshDate;
    
    private List<ImageDTO> images;
    
    private UserDTO user;
    
    public AdvertisementDTO(Advertisement advertisement, List<ImageDTO> images) {
        id = advertisement.getId();
        title = advertisement.getTitle();
        description = advertisement.getDescription();
        price = advertisement.getPrice();
        addDate = advertisement.getAddDate();
        refreshDate = advertisement.getRefreshDate();
        this.images = images;
        user = new UserDTO(advertisement.getUser());
    }
    
}
