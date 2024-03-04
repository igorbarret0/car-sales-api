package com.igorbarreto.api.service;

import com.igorbarreto.api.dto.OwnerPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface OwnerPostService {

    void createOwner(OwnerPostDTO ownerPostDTO);
}
