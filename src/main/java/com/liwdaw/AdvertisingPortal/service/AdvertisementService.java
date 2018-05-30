package com.liwdaw.AdvertisingPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liwdaw.AdvertisingPortal.dto.AdvertisementDTO;
import com.liwdaw.AdvertisingPortal.entity.Advertisement;
import com.liwdaw.AdvertisingPortal.entity.Image;
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

    public AdvertisementDTO getAdvertisementByIdAndStatus(int id, String status) {
        Advertisement advertisement = advertisementRepository.findByIdAndStatus(id, status);
        List<Image> images = imageRepository.findByAdvertisementId(advertisement.getId());
        AdvertisementDTO advertisementDTO = new AdvertisementDTO(advertisement, images);
        return advertisementDTO;
    }

    public List<AdvertisementDTO> getAdvertisementByUserIdAndStatus(int userId, String status) {
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findByUserIdAndStatus(userId, status);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getAdvertisementBySubCategoryIdAndStatus(int subCategoryId, String status) {
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findBySubCategoryIdAndStatus(subCategoryId, status);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getAdvertisementByCategoryIdAndStatus(int categoryId, String status) {
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findBySubCategoryCategoryIdAndStatus(categoryId, status);
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
        advertisement.setStatus("NEW");
        advertisement.setSubCategory(subCategoryRepository.findById(advertisementRequest.getSubCategoryId()));
        advertisement.setUser(userRepository.findById(advertisementRequest.getUserId()));
        advertisement = advertisementRepository.save(advertisement);
        advertisementRequest.getImageRequests().forEach(e -> {
            Image image = new Image();
            image.setPath(e.getPath());
            imageRepository.save(image);
        });
    }

}
