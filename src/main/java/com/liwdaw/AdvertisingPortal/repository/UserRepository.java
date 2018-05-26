package com.liwdaw.AdvertisingPortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwdaw.AdvertisingPortal.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    public User findById(int id);
    
    public User findByEmailAndPassword(String email, String password);
    
    public List<User> findByNameContainingIgnoreCase(String name);
    
}
