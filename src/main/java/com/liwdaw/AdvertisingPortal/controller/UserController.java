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

import com.liwdaw.AdvertisingPortal.dto.UserDTO;
import com.liwdaw.AdvertisingPortal.request.LoginRequest;
import com.liwdaw.AdvertisingPortal.request.UserRequest;
import com.liwdaw.AdvertisingPortal.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;
    
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getAuthenticatedUser() {
        UserDTO user = service.getAuthenticatedUser();
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }
    
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @PostMapping("/login")
    public ResponseEntity<UserDTO> loginUser(@RequestBody LoginRequest loginRequest) {
        UserDTO user = service.getUserByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }
    
    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserRequest userRequest) {
        service.addUser(userRequest);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
}
