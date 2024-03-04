package com.igorbarreto.api.controller;

import com.igorbarreto.api.dto.CarPostDTO;
import com.igorbarreto.api.message.KafkaProducerMessage;
import com.igorbarreto.api.service.CarPostStoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarPostController {


    private CarPostStoreService carPostStoreService;

    private KafkaProducerMessage kafkaProducerMessage;

    public CarPostController(CarPostStoreService carPostStoreService, KafkaProducerMessage kafkaProducerMessage) {
        this.carPostStoreService = carPostStoreService;
        this.kafkaProducerMessage = kafkaProducerMessage;
    }

    @PostMapping("/post")
    public ResponseEntity postCarForSale(@RequestBody CarPostDTO carPostDTO) {

        kafkaProducerMessage.sendMessage(carPostDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {

        return ResponseEntity.status(HttpStatus.FOUND).body(carPostStoreService.getCarForSales());
    }

    @PutMapping("/id")
    public ResponseEntity changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") Long id) {

        carPostStoreService.changeCarForSale(carPostDTO, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity deleteCarForSale(@PathVariable("id") Long id) {

        carPostStoreService.removeCarFromSale(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
