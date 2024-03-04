package com.igorbarreto.carStore.service.impl;

import com.igorbarreto.carStore.dto.OwnerPostDTO;
import com.igorbarreto.carStore.entity.OwnerPostEntity;
import com.igorbarreto.carStore.repository.OwnerPostRepository;
import com.igorbarreto.carStore.service.OwnerPostService;
import org.springframework.stereotype.Service;

@Service
public class OwnerPostServiceImpl implements OwnerPostService {

    private OwnerPostRepository ownerPostRepository;

    public OwnerPostServiceImpl(OwnerPostRepository ownerPostRepository) {
        this.ownerPostRepository = ownerPostRepository;
    }
    @Override
    public void createOwnerPost(OwnerPostDTO ownerPostDTO) {

        OwnerPostEntity ownerPost = new OwnerPostEntity();
        ownerPost.setName(ownerPostDTO.name());
        ownerPost.setType(ownerPostDTO.type());
        ownerPost.setContactNumber(ownerPostDTO.contactNumber());

        ownerPostRepository.save(ownerPost);

    }
}
