package com.igorbarreto.analitycsservice.service.impl;

import com.igorbarreto.analitycsservice.dto.CarPostDTO;
import com.igorbarreto.analitycsservice.entity.BrandAnalitycsEntity;
import com.igorbarreto.analitycsservice.entity.CarModelAnalitycsEntity;
import com.igorbarreto.analitycsservice.entity.CarModelPriceEntity;
import com.igorbarreto.analitycsservice.repository.BrandAnalitycsRepository;
import com.igorbarreto.analitycsservice.repository.CarModelAnalitycsRepository;
import com.igorbarreto.analitycsservice.repository.CarModelPriceRepository;
import com.igorbarreto.analitycsservice.service.PostAnalyticsService;
import org.springframework.stereotype.Service;

@Service
public class PostAnalyticsServiceImpl implements PostAnalyticsService {

    private BrandAnalitycsRepository brandAnalitycsRepository;
    private CarModelAnalitycsRepository carModelAnalitycsRepository;
    private CarModelPriceRepository carModelPriceRepository;

    public PostAnalyticsServiceImpl(BrandAnalitycsRepository brandAnalitycsRepository, CarModelAnalitycsRepository carModelAnalitycsRepository,
                                    CarModelPriceRepository carModelPriceRepository) {
        this.brandAnalitycsRepository = brandAnalitycsRepository;
        this.carModelAnalitycsRepository = carModelAnalitycsRepository;
        this.carModelPriceRepository = carModelPriceRepository;
    }

    @Override
    public void saveDataAnalytics(CarPostDTO carPostDTO) {

        saveBrandAnalytics(carPostDTO.brand());
        saveCarModelAnalytics(carPostDTO.model());
        saveCarModelPriceAnalytics(carPostDTO.price(), carPostDTO.model());
    }

    private void saveBrandAnalytics(String brand) {

        BrandAnalitycsEntity brandAnalitycsEntity = new BrandAnalitycsEntity();

        brandAnalitycsRepository.findByBrand(brand).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            brandAnalitycsRepository.save(item);
        }, () -> {
            brandAnalitycsEntity.setBrand(brand);
            brandAnalitycsEntity.setPosts(1L);
            brandAnalitycsRepository.save(brandAnalitycsEntity);
        });
    }

    private void saveCarModelAnalytics(String model) {

        CarModelAnalitycsEntity carModelAnalitycsEntity = new CarModelAnalitycsEntity();

        carModelAnalitycsRepository.findByModel(model).ifPresentOrElse(item -> {
            item.setPosts(item.getPosts() + 1);
            carModelAnalitycsRepository.save(item);
        }, () -> {
            carModelAnalitycsEntity.setModel(model);
            carModelAnalitycsEntity.setPosts(1L);
            carModelAnalitycsRepository.save(carModelAnalitycsEntity);
        });
    }

    private void saveCarModelPriceAnalytics(Double price, String model) {

        CarModelPriceEntity carModelPriceEntity = new CarModelPriceEntity();

        carModelPriceEntity.setModel(model);
        carModelPriceEntity.setPrice(price);
        carModelPriceRepository.save(carModelPriceEntity);
    }

}
