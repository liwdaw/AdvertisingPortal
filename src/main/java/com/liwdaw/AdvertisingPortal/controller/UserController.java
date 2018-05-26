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

import com.liwdaw.AdvertisingPortal.dto.UserDTO;
import com.liwdaw.AdvertisingPortal.entity.User;
import com.liwdaw.AdvertisingPortal.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService service;
    
    @GetMapping("id={id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Integer id) {
        UserDTO user = service.getUserById(id);
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }
    
    // remember to add security
    @GetMapping("email={email}&password={password}")
    public ResponseEntity<UserDTO> getUserByEmailAndPassword(@PathVariable("email") String email, @PathVariable("password") String password) {
        UserDTO user = service.getUserByEmailAndPassword(email, password);
        return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
    }
    
    @GetMapping("name={name}")
    public ResponseEntity<List<UserDTO>> getUsersByNameContaining(@PathVariable("name") String name) {
        List<UserDTO> users = service.getUsersByNameContaining(name);
        return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK);
    }
    
    // remember to modify this - should return conflict, validate data and maybe some wrapper?
    @PostMapping
    public ResponseEntity<Void> addUser(@RequestBody User user) {
        service.addUser(user);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
}
