package com.igorbarreto.api.service.impl;

import com.igorbarreto.api.client.CarPostStoreClient;
import com.igorbarreto.api.dto.CarPostDTO;
import com.igorbarreto.api.service.CarPostStoreService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarPostStoreServiceImpl implements CarPostStoreService {

    private CarPostStoreClient carPostStoreClient;

    public CarPostStoreServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }

    @Override
    public List<CarPostDTO> getCarForSales() {
        return  carPostStoreClient.carForSalesClient();
    }

    @Override
    public void changeCarForSale(CarPostDTO carPostDTO, Long id) {
        carPostStoreClient.changeCarForSalesClient(carPostDTO, id);
    }

    @Override
    public void removeCarFromSale(Long id) {
        carPostStoreClient.deleteCarForSalesClient(id);
    }
}
