package com.car.systems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.car.systems.models.Car;
import com.car.systems.models.User;
import com.car.systems.repositories.UserRepository;
import com.car.systems.services.CarService;

@Controller()
@RequestMapping(path = "/car")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/list")
	@ResponseBody
	public Iterable<Car> getAllCars() {
		return carService.getAllCars();
	}

	@PostMapping()
	@ResponseBody
	public String addNewCar(@RequestBody Car car) {
		carService.saveCar(car);
		return "Saved";
	}

	@DeleteMapping()
	public String delete(@RequestParam Long carId) {
		carService.deleteCar(carId);
		return "Deleted";
	}
}
