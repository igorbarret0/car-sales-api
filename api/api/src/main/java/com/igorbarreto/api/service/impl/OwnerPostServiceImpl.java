package com.igorbarreto.api.service.impl;

import com.igorbarreto.api.client.CarPostStoreClient;
import com.igorbarreto.api.dto.OwnerPostDTO;
import com.igorbarreto.api.service.OwnerPostService;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    private CarPostStoreClient carPostStoreClient;

    public OwnerPostServiceImpl(CarPostStoreClient carPostStoreClient) {
        this.carPostStoreClient = carPostStoreClient;
    }
    @Override
    public void createOwner(OwnerPostDTO ownerPostDTO) {

        carPostStoreClient.ownerPostClients(ownerPostDTO);
    }
}
