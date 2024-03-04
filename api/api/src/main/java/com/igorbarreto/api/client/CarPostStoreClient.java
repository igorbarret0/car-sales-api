package com.igorbarreto.api.client;

import com.igorbarreto.api.dto.CarPostDTO;
import com.igorbarreto.api.dto.OwnerPostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Component
public class CarPostStoreClient {

    private final String USER_STORE_SERVICE_URI = "http://localhost:8080/user";
    private final String POSTS_STORE_SERVICE_URI = "http://localhost:8080/sales";

    private final RestTemplate restTemplate;

    public CarPostStoreClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<CarPostDTO> carForSalesClient() {

        ResponseEntity<CarPostDTO[]> responseEntity = restTemplate.getForEntity(POSTS_STORE_SERVICE_URI+"/cars", CarPostDTO[].class);
        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    public void ownerPostClients(OwnerPostDTO newUser) {

        restTemplate.postForEntity(USER_STORE_SERVICE_URI, newUser, OwnerPostDTO.class);
    }

    public void changeCarForSalesClient(CarPostDTO carPostDTO, Long id) {

        restTemplate.put(POSTS_STORE_SERVICE_URI+"/car"+id, carPostDTO, CarPostDTO.class);
    }

    public void deleteCarForSalesClient(Long id) {

        restTemplate.delete(POSTS_STORE_SERVICE_URI+"/car"+id);
    }
}
