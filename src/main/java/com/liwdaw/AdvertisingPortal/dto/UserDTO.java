package com.liwdaw.AdvertisingPortal.dto;

import com.liwdaw.AdvertisingPortal.entity.User;

import lombok.Data;

@Data
public class UserDTO {

	private int id;
	
	private String email;
	
	private String name;
	
	private String city;
	
	private String phoneNumber;
	
	private String role;
	
	public UserDTO(User user) {
		id = user.getId();
		email = user.getEmail();
		name = user.getName();
		city = user.getCity();
		phoneNumber = user.getPhoneNumber();
		role = user.getRole();
	}
	
}
