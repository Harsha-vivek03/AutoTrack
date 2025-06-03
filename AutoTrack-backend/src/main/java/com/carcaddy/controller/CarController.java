package com.carcaddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.carcaddy.exception.InvalidEntityException;
import com.carcaddy.model.Car;
import com.carcaddy.service.CarService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/addCarDetails")
    public ResponseEntity<String> addCarDetails(@RequestBody Car car) throws InvalidEntityException {
        return ResponseEntity.ok(carService.handleCarDetails(car));  // Only call service and return response
    }

    @GetMapping("/{carId}")
    public Car getCarDetails(@PathVariable Long carId) throws InvalidEntityException {
        return carService.getCarDetails(carId);
    }
    
   
    @GetMapping("/allCar")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }
}
