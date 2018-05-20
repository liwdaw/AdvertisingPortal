package com.liwdaw.AdvertisingPortal.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="category")
public class Category {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="category_id")
    private int categoryID;
    
    @Column(name="name")
    private String name;
    
}
