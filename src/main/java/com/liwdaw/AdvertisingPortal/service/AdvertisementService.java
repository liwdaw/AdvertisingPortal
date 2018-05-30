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

    public AdvertisementDTO getAdvertisementById(int id) {
        String status = "CONFIRMED";
        Advertisement advertisement = advertisementRepository.findByIdAndStatus(id, status);
        List<Image> images = imageRepository.findByAdvertisementId(advertisement.getId());
        AdvertisementDTO advertisementDTO = new AdvertisementDTO(advertisement, images);
        return advertisementDTO;
    }

    public List<AdvertisementDTO> getAdvertisementsByUserId(int userId) {
        String status = "CONFIRMED";
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findByUserIdAndStatus(userId, status);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getAdvertisementsBySubCategoryId(int subCategoryId) {
        String status = "CONFIRMED";
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findBySubCategoryIdAndStatus(subCategoryId, status);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getAdvertisementsByCategoryId(int categoryId) {
        String status = "CONFIRMED";
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findBySubCategoryCategoryIdAndStatus(categoryId, status);
        advertisements.forEach(e -> {
            List<Image> images = imageRepository.findByAdvertisementId(e.getId());
            advertisementsDTO.add(new AdvertisementDTO(e, images));
        });
        return advertisementsDTO;
    }
    
    public List<AdvertisementDTO> getNewAdvertisements() {
        String status = "NEW";
        List<AdvertisementDTO> advertisementsDTO = new ArrayList<>();
        List<Advertisement> advertisements = advertisementRepository.findByStatus(status);
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
        advertisementRequest.getImagesPaths().forEach(e -> {
            Image image = new Image();
            image.setPath(e);
            imageRepository.save(image);
        });
    }

}
