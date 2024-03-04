package com.igorbarreto.carStore.service.impl;

import com.igorbarreto.carStore.dto.CarPostDTO;
import com.igorbarreto.carStore.entity.CarPostEntity;
import com.igorbarreto.carStore.repository.CarPostRepository;
import com.igorbarreto.carStore.repository.OwnerPostRepository;
import com.igorbarreto.carStore.service.CarPostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CarPostServiceImpl implements CarPostService {

    private CarPostRepository carPostRepository;
    private OwnerPostRepository ownerPostRepository;

    public CarPostServiceImpl(CarPostRepository carPostRepository, OwnerPostRepository ownerPostRepository) {
        this.carPostRepository = carPostRepository;
        this.ownerPostRepository = ownerPostRepository;
    }

    @Override
    public void newPostDetails(CarPostDTO carPostDTO) {

        CarPostEntity carPostEntity = mapCarDtoToEntity(carPostDTO);
        carPostRepository.save(carPostEntity);
    }

    @Override
    public List<CarPostDTO> getCarSales() {

        List<CarPostDTO> listCarSales = new ArrayList<>();
        carPostRepository.findAll().forEach(item -> {
            listCarSales.add(mapCarEntityToDTO(item));
        });

        return listCarSales;
    }

    @Override
    public void changeCarSale(CarPostDTO carPostDTO, Long id) {

        carPostRepository.findById(id).ifPresentOrElse(item -> {
            item.setModel(carPostDTO.model());
            item.setBrand(carPostDTO.brand());
            item.setPrice(carPostDTO.price());
            item.setDescription(carPostDTO.description());
            item.setEngine(carPostDTO.engineVersion());
            item.setCity(carPostDTO.city());
            item.setCreatedDate(carPostDTO.createdDate());

            carPostRepository.save(item);
        }, () -> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void removeCarSale(Long id) {

        carPostRepository.findById(id).ifPresentOrElse(item ->
                carPostRepository.delete(item), () -> {
            throw new NoSuchElementException();
        });
    }

    private CarPostDTO mapCarEntityToDTO(CarPostEntity carPostEntity) {

        return CarPostDTO.carEntityToCarPostDTO(carPostEntity);
    }

    private CarPostEntity mapCarDtoToEntity(CarPostDTO carPostDTO) {

        CarPostEntity carPostEntity = new CarPostEntity();

        ownerPostRepository.findById(carPostDTO.ownerId()).ifPresentOrElse(item -> {
            carPostEntity.setOwnerPost(item);
            carPostEntity.setContact(item.getContactNumber());
        }, () -> {
            throw new RuntimeException();
        });

        carPostEntity.setModel(carPostDTO.model());
        carPostEntity.setBrand(carPostDTO.brand());
        carPostEntity.setPrice(carPostDTO.price());
        carPostEntity.setCity(carPostDTO.city());
        carPostEntity.setDescription(carPostDTO.description());
        carPostEntity.setEngine(carPostDTO.engineVersion());
        carPostEntity.setCreatedDate(String.valueOf(new Date()));

        return carPostEntity;
    }

}
