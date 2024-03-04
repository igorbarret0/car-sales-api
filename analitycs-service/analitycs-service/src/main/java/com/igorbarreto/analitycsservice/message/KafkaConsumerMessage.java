package com.igorbarreto.analitycsservice.message;

import com.igorbarreto.analitycsservice.dto.CarPostDTO;
import com.igorbarreto.analitycsservice.service.PostAnalyticsService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerMessage {


    private PostAnalyticsService postAnalyticsService;

    public KafkaConsumerMessage(PostAnalyticsService postAnalyticsService) {
        this.postAnalyticsService = postAnalyticsService;
    }

    @KafkaListener(topics = "car-post-topic", groupId = "analytics-posts-group")
    public void listening(@Payload CarPostDTO carPostDTO) {

        postAnalyticsService.saveDataAnalytics(carPostDTO);
    }

}
