package com.liwdaw.AdvertisingPortal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.liwdaw.AdvertisingPortal.model.AdvertisementStatus;
import com.liwdaw.AdvertisingPortal.request.AdvertisementRequest;

import lombok.Data;

@Data
@Entity
@Table(name="advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="advertisement_id")
    private int id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="description")
    private String description;
    
    @Column(name="price")
    private int price;
    
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private AdvertisementStatus status;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="add_date")
    private Date addDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="refresh_Date")
    private Date refreshDate;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="sub_category_id")
    private SubCategory subCategory;
    
}
