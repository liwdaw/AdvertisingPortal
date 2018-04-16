package com.liwdaw.AdvertisingPortal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.liwdaw.AdvertisingPortal.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
