package com.igorbarreto.api.dto;

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
}
