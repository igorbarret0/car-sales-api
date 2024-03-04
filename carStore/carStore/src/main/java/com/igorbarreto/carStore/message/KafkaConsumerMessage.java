package com.igorbarreto.carStore.message;

import com.igorbarreto.carStore.dto.CarPostDTO;
import com.igorbarreto.carStore.service.CarPostService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaConsumerMessage {

    private CarPostService carPostService;

    public KafkaConsumerMessage(CarPostService carPostService) {
        this.carPostService = carPostService;
    }

    @KafkaListener(topics = "car-post-topic", groupId = "store-posts-group")
    public void listening(CarPostDTO carPostDTO ) {

        carPostService.newPostDetails(carPostDTO);
    }

}
