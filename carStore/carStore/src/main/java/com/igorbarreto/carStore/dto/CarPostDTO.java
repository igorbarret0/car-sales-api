package com.igorbarreto.carStore.dto;

import com.igorbarreto.carStore.entity.CarPostEntity;
import com.igorbarreto.carStore.repository.OwnerPostRepository;

public record CarPostDTO(
        String model,
        String brand,
        Double price,
        String description,
        String engineVersion,
        String city,
        String createdDate,
        Long ownerId,
        String ownerName,
        String ownerType,
        String contact
) {

    public static CarPostDTO carEntityToCarPostDTO(CarPostEntity carPostEntity) {

        return new CarPostDTO(
                carPostEntity.getModel(),
                carPostEntity.getBrand(),
                carPostEntity.getPrice(),
                carPostEntity.getDescription(),
                carPostEntity.getEngine(),
                carPostEntity.getCity(),
                carPostEntity.getCreatedDate(),
                carPostEntity.getOwnerPost().getId(),
                carPostEntity.getOwnerPost().getName(),
                carPostEntity.getOwnerPost().getType(),
                carPostEntity.getOwnerPost().getContactNumber()
        );
    }


}
