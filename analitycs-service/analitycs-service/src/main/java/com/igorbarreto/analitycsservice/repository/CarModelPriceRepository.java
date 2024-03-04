package com.igorbarreto.analitycsservice.repository;

import com.igorbarreto.analitycsservice.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CarModelPriceRepository extends JpaRepository<CarModelPriceEntity, Long> {

    Optional<CarModelPriceEntity> findByModel(String model);
}
