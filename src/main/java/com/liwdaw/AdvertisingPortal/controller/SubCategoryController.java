package com.liwdaw.AdvertisingPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liwdaw.AdvertisingPortal.DTO.SubCategoryDTO;
import com.liwdaw.AdvertisingPortal.service.SubCategoryService;

@Controller
@RequestMapping("subcategory")
public class SubCategoryController {

	@Autowired
	private SubCategoryService service;
	
    @GetMapping("id={id}")
    public ResponseEntity<SubCategoryDTO> getSubCategoryById(@PathVariable("id") Integer id) {
        SubCategoryDTO subCategory = service.getSubCategoryById(id);
        return new ResponseEntity<SubCategoryDTO>(subCategory, HttpStatus.OK);
    }
    
    @GetMapping("name={name}")
    public ResponseEntity<SubCategoryDTO> getSubCategoryByName(@PathVariable("name") String name) {
        SubCategoryDTO subCategory = service.getSubCategoryByName(name);
        return new ResponseEntity<SubCategoryDTO>(subCategory, HttpStatus.OK);
    }
    
    @GetMapping("category/id={id}")
    public ResponseEntity<SubCategoryDTO> getSubCategoryByCategoryId(@PathVariable("id") Integer id) {
        SubCategoryDTO subCategory = service.getSubCategoryById(id);
        return new ResponseEntity<SubCategoryDTO>(subCategory, HttpStatus.OK);
    }
    
    @GetMapping("category/name={name}")
    public ResponseEntity<SubCategoryDTO> getSubCategoryByCategoryName(@PathVariable("name") String name) {
        SubCategoryDTO subCategory = service.getSubCategoryByName(name);
        return new ResponseEntity<SubCategoryDTO>(subCategory, HttpStatus.OK);
    }
    
}
