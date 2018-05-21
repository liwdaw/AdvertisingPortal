package com.liwdaw.AdvertisingPortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liwdaw.AdvertisingPortal.DTO.CategoryDTO;
import com.liwdaw.AdvertisingPortal.service.CategoryService;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService service;
    
    @GetMapping("id={id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable("id") Integer id) {
        CategoryDTO category = service.getCategoryById(id);
        return new ResponseEntity<CategoryDTO>(category, HttpStatus.OK);
    }
    
    @GetMapping("name={name}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable("name") String name) {
        CategoryDTO category = service.getCategoryByName(name);
        return new ResponseEntity<CategoryDTO>(category, HttpStatus.OK);
    }
    
    @GetMapping("all")
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
        List<CategoryDTO> categories = service.getAllCategories();
        return new ResponseEntity<List<CategoryDTO>>(categories, HttpStatus.OK);
    }
    
}
