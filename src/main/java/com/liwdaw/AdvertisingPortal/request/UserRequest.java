package com.liwdaw.AdvertisingPortal.request;

import lombok.Data;

@Data
public class UserRequest {
    
    private String email;
    
    private String password;
    
    private String name;
    
    private String city;
    
    private String phoneNumber;
    
}
