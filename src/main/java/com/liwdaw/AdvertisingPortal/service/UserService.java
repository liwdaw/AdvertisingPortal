package com.liwdaw.AdvertisingPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.liwdaw.AdvertisingPortal.dto.UserDTO;
import com.liwdaw.AdvertisingPortal.entity.User;
import com.liwdaw.AdvertisingPortal.repository.UserRepository;
import com.liwdaw.AdvertisingPortal.request.UserRequest;

@Transactional
@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    
    public UserDTO getUserById(int id) {
        UserDTO user = new UserDTO(repository.findById(id));
        return user;
    }
    
    public UserDTO getUserByEmailAndPassword(String email, String password) {
        UserDTO user = new UserDTO(repository.findByEmailAndPassword(email, password));
        return user;
    }
    
    public List<UserDTO> getUsersByNameContaining(String name) {
        List<UserDTO> users = new ArrayList<>();
        repository.findByNameContainingIgnoreCase(name).forEach(e -> users.add(new UserDTO(e)));
        return users;
    }
    
    public void addUser(UserRequest userRequest) {
        User user = new User(userRequest);
        repository.save(user);
    }
    
}
