package com.carcaddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carcaddy.exception.InvalidEntityException;
import com.carcaddy.model.Car;
import com.carcaddy.repository.CarRepository;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;
  
    public String handleCarDetails(Car car) throws InvalidEntityException {
       
        validateCarDetails(car);

        carRepository.save(car);

      
        return "Car details added successfully";
    }

    private void validateCarDetails(Car car) throws InvalidEntityException {
      
        if (car.getVehicleType() == null || car.getVehicleType().isEmpty()) {
            throw new InvalidEntityException("Vehicle type is required.");
        }
        if (car.getModel() == null || car.getModel().isEmpty()) {
            throw new InvalidEntityException("Model is required.");
        }
        if (car.getYearOfManufacture() < 1900 || car.getYearOfManufacture() > 2025) {
            throw new InvalidEntityException("Year of manufacture must be between 1900 and 2025.");
        }
        if (car.getMileage() <= 0) {
            throw new InvalidEntityException("Mileage must be positive.");
        }
        if (car.getLastMaintenanceDate() == null) {
            throw new InvalidEntityException("Last maintenance date is required.");
        }
        if (car.getNextMaintenanceDate() == null || car.getNextMaintenanceDate().isBefore(car.getLastMaintenanceDate())) {
            throw new InvalidEntityException("Next maintenance date must be after the last maintenance date.");
        }
    }
    public Car getCarDetails(Long carId) throws InvalidEntityException {
    	return carRepository.findById(carId).orElseThrow(
    			() -> new InvalidEntityException("Car with ID " + carId + " not found."));
    }
    
    public List<Car> getAllCars() {
    	return carRepository.findAll();
    }
}
