package com.liwdaw.AdvertisingPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @GetMapping("/new")
    public ResponseEntity<List<AdvertisementDTO>> getNewAdvertisements() {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getNewAdvertisements();
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @GetMapping("/ad_id={id}")
    public ResponseEntity<AdvertisementDTO> getAdvertisementById(@PathVariable("id") Integer id) {
        AdvertisementDTO advertisementDTO = advertisementService.getAdvertisementById(id);
        return new ResponseEntity<AdvertisementDTO>(advertisementDTO, HttpStatus.OK);
    }
    
    @GetMapping("/subcategory_id={id}")
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisementsBySubCategoryId(@PathVariable("id") Integer id) {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getAdvertisementsBySubCategoryId(id);
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @GetMapping("/category_id={id}")
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisementsByCategoryId(@PathVariable("id") Integer id) {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getAdvertisementsByCategoryId(id);
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @GetMapping("/user_id={id}")
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisementsByUserId(@PathVariable("id") Integer id) {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getAdvertisementsByUserId(id);
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Void> addAdvertisement(@RequestBody AdvertisementRequest advertisementRequest) {
        advertisementService.addAdvertisement(advertisementRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }   
    
}
