package com.liwdaw.AdvertisingPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.liwdaw.AdvertisingPortal.request.UserRequest;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
    
    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
    
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
    private String role;
    
    @Column(name="enabled")
    private boolean enabled;
    
    public String getPassword() {
        return PASSWORD_ENCODER.encode(password);
    }
    
}
