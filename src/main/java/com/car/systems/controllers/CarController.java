package com.car.systems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.systems.models.Car;
import com.car.systems.services.CarService;

@Controller()
@RequestMapping(path = "/car")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/list")
	@ResponseBody
	public ResponseEntity<Iterable<Car>> getAllCars() {
		return new ResponseEntity<Iterable<Car>>(carService.getAllCars(),HttpStatus.OK);
	}

	@PostMapping()
	@ResponseBody
	public ResponseEntity<String> addNewCar(@RequestBody Car car) {
		carService.saveCar(car);
		return new ResponseEntity<String>("Saved",HttpStatus.CREATED);
	}

	@DeleteMapping()
	public ResponseEntity<String> delete(@RequestParam Long carId) {
		carService.deleteCar(carId);
		return new ResponseEntity<String>("Deleted car",HttpStatus.OK);
	}
	
	@GetMapping("/compare")
	@ResponseBody
	public ResponseEntity<Iterable<Car>> compareCars(@RequestParam Long carId1,@RequestParam Long carId2) {
		return new ResponseEntity<Iterable<Car>>(carService.compareCars(carId1,carId2),HttpStatus.OK);
	}
}
