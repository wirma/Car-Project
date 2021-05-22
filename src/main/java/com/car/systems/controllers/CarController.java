package com.car.systems.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping()
	@ResponseBody
	public Iterable<Car> getAllCars() {
		return carService.getAllCars();
	}

	@PostMapping()
	@ResponseBody
	public String addNewUser(@RequestParam String name) {
		carService.saveCar(name);
		return "Saved";
	}

	@DeleteMapping()
	public String delete() {
		return "Delete!";
	}
}
