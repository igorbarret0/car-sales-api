package com.igorbarreto.api.message;

import com.igorbarreto.api.dto.CarPostDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducerMessage {

    private KafkaTemplate<String, CarPostDTO> kafkaTemplate;

    private final String KAFKA_TOPIC = "car-post-topic";

    public KafkaProducerMessage(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CarPostDTO carPostDTO) {

        kafkaTemplate.send(KAFKA_TOPIC, carPostDTO);
    }


}
