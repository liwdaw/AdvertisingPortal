package com.liwdaw.AdvertisingPortal.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liwdaw.AdvertisingPortal.entity.Advertisement;
import com.liwdaw.AdvertisingPortal.entity.Image;

import lombok.Data;

@Data
public class AdvertisementDTO {

    private int id;
    
    private String title;
    
    private String description;
    
    private int price;
    
    private Date addDate;
    
    private Date refreshDate;
    
    private String status;
    
    private List<String> images = new ArrayList<>();
    
    private UserDTO user;
    
    public AdvertisementDTO(Advertisement advertisement, List<Image> images) {
        id = advertisement.getId();
        title = advertisement.getTitle();
        description = advertisement.getDescription();
        price = advertisement.getPrice();
        addDate = advertisement.getAddDate();
        refreshDate = advertisement.getRefreshDate();
        if (advertisement.getStatus().toString().equals("CONFIRMED")) {
            status = "ACTIVE";
        }
        else {
            status = advertisement.getStatus().toString();
        }
        images.forEach(e -> this.images.add(e.getImage()));
        user = new UserDTO(advertisement.getUser());
    }
    
}
