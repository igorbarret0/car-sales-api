package com.igorbarreto.analitycsservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car_model_price")
public class CarModelPriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private Double price;

    public CarModelPriceEntity(Long id, String model, Double price) {
        this.id = id;
        this.model = model;
        this.price = price;
    }

    public CarModelPriceEntity() {}

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
