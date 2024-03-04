package com.igorbarreto.carStore.service;

import com.igorbarreto.carStore.dto.OwnerPostDTO;
import com.igorbarreto.carStore.repository.OwnerPostRepository;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwnerPost(OwnerPostDTO ownerPostDTO);


}
