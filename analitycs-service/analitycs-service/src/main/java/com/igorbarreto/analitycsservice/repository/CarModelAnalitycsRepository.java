package com.igorbarreto.analitycsservice.repository;

import com.igorbarreto.analitycsservice.entity.CarModelAnalitycsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CarModelAnalitycsRepository extends JpaRepository<CarModelAnalitycsEntity, Long> {

    Optional<CarModelAnalitycsEntity> findByModel(String model);
}
