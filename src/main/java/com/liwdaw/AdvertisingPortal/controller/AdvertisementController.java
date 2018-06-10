package com.liwdaw.AdvertisingPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/new")
    public ResponseEntity<List<AdvertisementDTO>> getNewAdvertisements() {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getNewAdvertisements();
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @GetMapping("/new_id={id}")
    public ResponseEntity<AdvertisementDTO> getNewAdvertisementById(@PathVariable("id") Integer id) {
        AdvertisementDTO advertisementDTO = advertisementService.getNewAdvertisementById(id);
        return new ResponseEntity<AdvertisementDTO>(advertisementDTO, HttpStatus.OK);
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
    
    @GetMapping("/subcategory_id={id}/search={search}")
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisementsBySubCategoryIdAndSearch(@PathVariable("id") Integer id, @PathVariable("search") String search) {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getAdvertisementsBySubCategoryIdAndSearch(id, search);
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @GetMapping("/category_id={id}")
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisementsByCategoryId(@PathVariable("id") Integer id) {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getAdvertisementsByCategoryId(id);
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @GetMapping("/category_id={id}/search={search}")
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisementsByCategoryIdAndSearch(@PathVariable("id") Integer id, @PathVariable("search") String search) {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getAdvertisementsByCategoryIdAndSearch(id, search);
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @GetMapping("/search={search}")
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisementsBySearch(@PathVariable("search") String search) {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getAdvertisementsBySearch(search);
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<AdvertisementDTO>> getAllAdvertisements() {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getAllAdvertisements();
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/user/me")
    public ResponseEntity<List<AdvertisementDTO>> getAdvertisementsByUserAuthentication() {
        List<AdvertisementDTO> advertisementsDTO = advertisementService.getAdvertisementsByUserAuthentication();
        return new ResponseEntity<List<AdvertisementDTO>>(advertisementsDTO, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/confirm")
    public ResponseEntity<Void> confirmAdvertisement(@RequestBody Integer id) {
        advertisementService.confirmAdvertisement(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }   
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/refresh")
    public ResponseEntity<Void> refreshAdvertisement(@RequestBody Integer id) {
        advertisementService.refreshAdvertisement(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }  
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/finish")
    public ResponseEntity<Void> finishAdvertisement(@RequestBody Integer id) {
        advertisementService.finishAdvertisement(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }  
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/block")
    public ResponseEntity<Void> blockAdvertisement(@RequestBody Integer id) {
        advertisementService.blockAdvertisement(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }  
    
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<Void> addAdvertisement(@RequestBody AdvertisementRequest advertisementRequest) {
        advertisementService.addAdvertisement(advertisementRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }   
    
}
