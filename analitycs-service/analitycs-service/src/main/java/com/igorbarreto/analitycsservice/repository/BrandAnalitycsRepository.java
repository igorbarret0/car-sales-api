package com.igorbarreto.analitycsservice.repository;

import com.igorbarreto.analitycsservice.entity.BrandAnalitycsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BrandAnalitycsRepository extends JpaRepository<BrandAnalitycsEntity, Long> {

    Optional<BrandAnalitycsEntity> findByBrand(String brand);
}
