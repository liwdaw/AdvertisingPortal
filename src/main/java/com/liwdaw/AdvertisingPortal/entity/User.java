package com.liwdaw.AdvertisingPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.liwdaw.AdvertisingPortal.model.UserRole;
import com.liwdaw.AdvertisingPortal.request.UserRequest;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_id")
    private int id;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="name")
    private String name;
    
    @Column(name="city")
    private String city;
    
    @Column(name="phone_number")
    private String phoneNumber;
    
    @Column(name="role")
    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    @Column(name="enabled")
    private boolean enabled;
    
    public String getPassword() {
        return password;
    }
    
}
