package com.igorbarreto.api.service;

import com.igorbarreto.api.dto.CarPostDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarPostStoreService {

        List<CarPostDTO> getCarForSales();

        void changeCarForSale(CarPostDTO carPostDTO, Long id);

        void removeCarFromSale(Long id);
}
