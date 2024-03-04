package com.igorbarreto.analitycsservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car_model_analitycs")
public class CarModelAnalitycsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private Long posts;

    public CarModelAnalitycsEntity(Long id, String model, Long posts) {
        this.id = id;
        this.model = model;
        this.posts = posts;
    }

    public CarModelAnalitycsEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getPosts() {
        return posts;
    }

    public void setPosts(Long posts) {
        this.posts = posts;
    }
}
