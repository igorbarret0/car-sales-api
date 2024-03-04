package com.igorbarreto.carStore.controller;

import com.igorbarreto.carStore.dto.CarPostDTO;
import com.igorbarreto.carStore.service.CarPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class CarPostController {

    private CarPostService carPostService;

    public CarPostController(CarPostService carPostService) {
        this.carPostService = carPostService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarPostDTO>> getCarSales() {

        return ResponseEntity.status(HttpStatus.FOUND).body(carPostService.getCarSales());
    }

    @PutMapping("/car/{id}")
    public ResponseEntity changeCarSale(@RequestBody CarPostDTO carPostDTO, @PathVariable("id") Long id) {

        carPostService.changeCarSale(carPostDTO, id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity removeCarSale(@PathVariable("id") Long id) {

        carPostService.removeCarSale(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
