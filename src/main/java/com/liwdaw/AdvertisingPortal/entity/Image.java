package com.liwdaw.AdvertisingPortal.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="image")
public class Image {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="image_id")
    private int id;
    
    @Column(name="path")
    private String path;
    
    @ManyToOne
    @JoinColumn(name="advertisement_id")
    private Advertisement advertisement;
    
}
