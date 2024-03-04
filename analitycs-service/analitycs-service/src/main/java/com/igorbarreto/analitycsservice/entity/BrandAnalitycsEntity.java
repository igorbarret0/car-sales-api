package com.igorbarreto.analitycsservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "brand_analitycs")
public class BrandAnalitycsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private Long posts;


    public BrandAnalitycsEntity(Long id, String brand, Long posts) {
        this.id = id;
        this.brand = brand;
        this.posts = posts;
    }

    public BrandAnalitycsEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Long getPosts() {
        return posts;
    }

    public void setPosts(Long posts) {
        this.posts = posts;
    }
}
