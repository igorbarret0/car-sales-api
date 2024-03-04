package com.igorbarreto.analitycsservice.service;

import com.igorbarreto.analitycsservice.dto.CarPostDTO;
import org.springframework.stereotype.Service;

@Service
public interface PostAnalyticsService {

    void saveDataAnalytics(CarPostDTO carPostDTO);

}
