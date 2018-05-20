package com.liwdaw.AdvertisingPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="sub_category")
public class SubCategory {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="sub_category_id")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    
}
