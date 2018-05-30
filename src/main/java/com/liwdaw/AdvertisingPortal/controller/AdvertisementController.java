package com.liwdaw.AdvertisingPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liwdaw.AdvertisingPortal.dto.AdvertisementDTO;
import com.liwdaw.AdvertisingPortal.request.AdvertisementRequest;
import com.liwdaw.AdvertisingPortal.service.AdvertisementService;

@Controller
@RequestMapping("/ad")
public class AdvertisementController {

    @Autowired
    private AdvertisementService advertisementService;
    
    @GetMapping("/id={id}")
    public ResponseEntity<AdvertisementDTO> getAdvertisementById(int id) {
        AdvertisementDTO advertisementDTO = advertisementService.getAdvertisementByIdAndStatus(id, "NEW");
        return new ResponseEntity<AdvertisementDTO>(advertisementDTO, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Void> addAdvertisement(@RequestBody AdvertisementRequest advertisementRequest) {
        advertisementService.addAdvertisement(advertisementRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
}
