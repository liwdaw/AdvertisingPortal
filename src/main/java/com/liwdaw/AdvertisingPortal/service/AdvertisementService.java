package com.liwdaw.AdvertisingPortal.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liwdaw.AdvertisingPortal.dto.AdvertisementDTO;
import com.liwdaw.AdvertisingPortal.entity.Advertisement;
import com.liwdaw.AdvertisingPortal.entity.Image;
import com.liwdaw.AdvertisingPortal.model.AdvertisementStatus;
import com.liwdaw.AdvertisingPortal.repository.AdvertisementRepository;
import com.liwdaw.AdvertisingPortal.repository.ImageRepository;
import com.liwdaw.AdvertisingPortal.repository.SubCategoryRepository;
import com.liwdaw.AdvertisingPortal.repository.UserRepository;
import com.liwdaw.AdvertisingPortal.request.AdvertisementRequest;


@Transactional
@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    @Autowired
    private ImageRepository imageRepository;
    
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    
    @Autowired
    private UserRepository userRepository;

    public AdvertisementDTO getAdvertisementById(int id) {
        Advertisement advertisement = advertisementRepository.findByIdAndStatus(id, AdvertisementStatus.NEW);
        List<Image> images = imageRepository.findByAdvertisementId(advertisement.getId());
        System.out.println(advertisement.getId());
        System.out.println(images.size());
        AdvertisementDTO advertisementDTO = new AdvertisementDTO(advertisement, images);
        return advertisementDTO;
    }

    public List<AdvertisementDTO> getAdvertisementsByUserAuthentication() {
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Advertisement> advertisements = advertisementRepository.findByUserEmail(authentication.getName());
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getAdvertisementsBySubCategoryId(int subCategoryId) {
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findBySubCategoryIdAndStatus(subCategoryId, AdvertisementStatus.CONFIRMED);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getAdvertisementsBySubCategoryIdAndSearch(int subCategoryId, String search) {
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findBySubCategoryIdAndStatusAndTitleContainingIgnoreCase(subCategoryId, AdvertisementStatus.CONFIRMED, search);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getAdvertisementsByCategoryIdAndSearch(int categoryId, String search) {
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findBySubCategoryCategoryIdAndStatusAndTitleContainingIgnoreCase(categoryId, AdvertisementStatus.CONFIRMED, search);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getAdvertisementsBySearch(String search) {
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findByStatusAndTitleContainingIgnoreCase(AdvertisementStatus.CONFIRMED, search);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getAdvertisementsByCategoryId(int categoryId) {
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findBySubCategoryCategoryIdAndStatus(categoryId, AdvertisementStatus.CONFIRMED);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getNewAdvertisements() {
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findByStatus(AdvertisementStatus.NEW);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public void addAdvertisement(AdvertisementRequest advertisementRequest) {
        Advertisement advertisement = new Advertisement();
        advertisement.setTitle(advertisementRequest.getTitle());
        advertisement.setDescription(advertisementRequest.getDescription());
        advertisement.setPrice(advertisementRequest.getPrice());
        advertisement.setStatus(AdvertisementStatus.NEW);
        advertisement.setSubCategory(subCategoryRepository.findById(advertisementRequest.getSubCategoryId()));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        advertisement.setUser(userRepository.findByEmail(authentication.getName()));
        final Advertisement addedAdvertisement = advertisementRepository.save(advertisement);
        advertisementRequest.getImages().forEach(e -> {
            Image image = new Image();
            image.setImage(e);
            image.setAdvertisement(addedAdvertisement);
            imageRepository.save(image);
        });
        
    }

    public void confirmAdvertisement(Integer id) {
        Advertisement advertisement = advertisementRepository.getOne(id);
        advertisement.setStatus(AdvertisementStatus.CONFIRMED);
        Date date = new Date();
        advertisement.setAddDate(date);
        advertisement.setRefreshDate(date);
        advertisementRepository.save(advertisement);
    }
    
    public void refreshAdvertisement(Integer id) {
        Advertisement advertisement = advertisementRepository.getOne(id);
        Date date = new Date();
        advertisement.setRefreshDate(date);
        advertisementRepository.save(advertisement);
    }
    
    public void finishAdvertisement(Integer id) {
        Advertisement advertisement = advertisementRepository.getOne(id);
        advertisement.setStatus(AdvertisementStatus.FINISHED);
        advertisementRepository.save(advertisement);
    }
    
    public void blockAdvertisement(Integer id) {
        Advertisement advertisement = advertisementRepository.getOne(id);
        advertisement.setStatus(AdvertisementStatus.BLOCKED);
        advertisementRepository.save(advertisement);
    }

}

